package com.zww.testrpc.transport;

import com.zww.testrpc.Peer;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 处理网络请求的Handler
 * @author zww
 * @date 2021/2/7 15:38
 */

public interface RequestHandler {
   void onRequest(InputStream recive, OutputStream toResp);
}
