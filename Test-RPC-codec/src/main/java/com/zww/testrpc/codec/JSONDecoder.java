package com.zww.testrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的反序列化实现
 * @author zww
 * @date 2021/2/7 15:20
 */

public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}
