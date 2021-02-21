package com.zww.testrpc.codec;

/**
 * 序列化
 * @author zww
 * @date 2021/2/7 15:10
 */

public interface Decoder {
        <T> T decode(byte[] bytes,Class<T> clazz);
}
