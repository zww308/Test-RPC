package com.zww.testrpc;

import lombok.Data;

/**
 * 表示RPC的返回
 * @author zww
 * @date 2021/2/7 14:44
 */
@Data
public class Response {
    /*
    服务返回编码，0-成功，非0失败
     */
    private int code=0;
    private String message="ok";
    private Object data;
}
