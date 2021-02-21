package com.zww.testrpc.transport;

import com.zww.testrpc.Peer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zww
 * @date 2021/2/7 15:45
 */
@Slf4j
public class HTTPTransportServer implements TransportServer {
    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        this.server = new Server(port);
        this.handler = handler;
        
        //servlet接收请求
        ServletContextHandler ctx = new ServletContextHandler();
        server.setHandler(ctx);
        ServletHolder holder = new ServletHolder(new RequestServlet());
        ctx.addServlet(holder,"/*");
    }

    @Override
    public void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
           log.error(e.getMessage(),e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }
    class RequestServlet extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("client connect！");
          InputStream in = req.getInputStream();
          OutputStream out = resp.getOutputStream();

          if(handler!=null){
              handler.onRequest(in,out);
            }
          out.flush();
        }
    }
}
