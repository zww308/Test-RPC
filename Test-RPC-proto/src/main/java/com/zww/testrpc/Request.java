package com.zww.testrpc;

import lombok.Data;

/**
 * 表示RPC的一个请求
 * @author zww
 * @date 2021/2/7 14:42
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
