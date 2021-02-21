package com.zww.testrpc.example;

import com.zww.testrpc.client.RpcClient;
import com.zww.testrpc.server.RpcServer;

/**
 * @author zww
 * @date 2021/2/21 15:02
 */

public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
