package com.zww.testrpc.server;

import com.zww.testrpc.Request;
import com.zww.testrpc.Response;
import com.zww.testrpc.codec.Decoder;
import com.zww.testrpc.codec.Encoder;
import com.zww.testrpc.common.utils.ReflectionUtils;
import com.zww.testrpc.transport.RequestHandler;
import com.zww.testrpc.transport.TransportServer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zww
 * @date 2021/2/7 17:07
 */
@Data
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream in, OutputStream out) {
            Response response = new Response();
            try {
                //byte[] bytes =IO
                byte[] bytes = IOUtils.readFully(in, in.available());
                Request request = decoder.decode(bytes, Request.class);
                log.info("get request: {}",request);
                ServiceInstance instance = serviceManager.lookup(request);
                Object data = serviceInvoker.invoke(instance, request);
                response.setData(data);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage(), e);
                response.setCode(-1);
                response.setMessage("RpcServer error: " +
                        e.getClass().getName()+" "+e.getMessage());
            } finally {

                try {
                    byte[] bytes = encoder.encode(response);
                    out.write(bytes);
                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(),e);
                    e.printStackTrace();
                }
            }
        }
    };

    public RpcServer() {
        this(new RpcServerConfig());
    }

    public RpcServer(RpcServerConfig config) {
        this.config = config;
        //net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), handler);
        //encode
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        //decode
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        //service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    //注册服务
    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass, bean);
    }

    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }
}
