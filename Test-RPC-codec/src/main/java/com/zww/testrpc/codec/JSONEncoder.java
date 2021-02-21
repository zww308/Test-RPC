package com.zww.testrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的反序列化
 * @author zww
 * @date 2021/2/7 15:14
 */

public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
