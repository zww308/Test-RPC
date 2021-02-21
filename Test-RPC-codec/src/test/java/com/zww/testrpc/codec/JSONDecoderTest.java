package com.zww.testrpc.codec;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author zww
 * @date 2021/2/7 15:21
 */


public class JSONDecoderTest {


    @Test
    public void decode() {
        Encoder encoder= new JSONEncoder();
        Decoder decoder = new JSONDecoder();
        TestBean bean = new TestBean();
        bean.setName("zww");
        bean.setAge(18);
        byte[] bytes = encoder.encode(bean);

        TestBean bean2 = decoder.decode(bytes,TestBean.class);
        assertEquals(bean.getName(),bean2.getName());
        assertEquals(bean.getAge(),bean2.getAge());
    }
}
