package com.zww.testrpc.codec;

/**
 * 反序列化
 * @author zww
 * @date 2021/2/7 15:10
 */

public interface Encoder {

        byte[] encode(Object obj);
}
