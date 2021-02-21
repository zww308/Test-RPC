package com.zww.testrpc.transport;

import com.zww.testrpc.Peer;

import java.io.InputStream;

/**
 * 1、启动监听端口
 * 2、接收请求
 * 3、关闭监听
 * @author zww
 * @date 2021/2/7 15:38
 */

public interface TransportServer {
   void init(int port,RequestHandler handler);
    void start();
    void stop();
}
