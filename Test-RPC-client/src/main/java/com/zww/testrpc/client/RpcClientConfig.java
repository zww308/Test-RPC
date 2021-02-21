package com.zww.testrpc.client;

import com.zww.testrpc.Peer;
import com.zww.testrpc.codec.Decoder;
import com.zww.testrpc.codec.Encoder;
import com.zww.testrpc.codec.JSONDecoder;
import com.zww.testrpc.codec.JSONEncoder;
import com.zww.testrpc.transport.HTTPTransportClient;
import com.zww.testrpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author zww
 * @date 2021/2/21 14:33
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1", 3000)
    );
}
