package com.zww.testrpc.server;

import com.zww.testrpc.codec.Decoder;
import com.zww.testrpc.codec.Encoder;
import com.zww.testrpc.codec.JSONDecoder;
import com.zww.testrpc.codec.JSONEncoder;
import com.zww.testrpc.transport.HTTPTransportServer;
import com.zww.testrpc.transport.TransportServer;
import lombok.Data;
import org.eclipse.jetty.server.HttpTransport;

/**
 * server配置
 * @author zww
 * @date 2021/2/7 16:14
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;

}
