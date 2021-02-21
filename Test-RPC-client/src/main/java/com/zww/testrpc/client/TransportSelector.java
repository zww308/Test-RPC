package com.zww.testrpc.client;

import com.zww.testrpc.Peer;
import com.zww.testrpc.transport.TransportClient;
import com.zww.testrpc.transport.TransportServer;
import sun.rmi.transport.Transport;

import java.util.List;

/**
 * 选则那个server区连接
 * @author zww
 * @date 2021/2/21 13:50
 */

public interface TransportSelector {
    /**
     * 初始化selector
     * @param peers  可以连接的server端点信息
     * @param count  client与server建立多少个连接
     * @param clazz client实现class
     */
    void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz);
    /**
     * 选择一个ransport与server做交互
     * @return 网络client
     */
    TransportClient select();

    /**
     * 释放用完的client
     * @param client
     */
    void release(TransportClient client);

    void close();
}
