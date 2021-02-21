package com.zww.testrpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表示网络传输的一个端点
 * @author zww
 * @date 2021/2/7 14:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peer {
    private String host;
    private int port;
}
