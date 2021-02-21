package com.zww.testrpc.transport;

import com.zww.testrpc.Peer;

import java.io.InputStream;

/**
 * 1、创建链接
 * 2、发送数据，并且等待响应
 * 3、关闭链接
 * @author zww
 * @date 2021/2/7 15:38
 */

public interface TransportClient {
    void connect(Peer peer);
    InputStream write(InputStream data);
    void close();
}
