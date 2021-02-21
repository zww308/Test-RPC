package com.zww.testrpc.codec;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author zww
 * @date 2021/2/7 15:22
 */


public class JSONEncoderTest {

    @Test
    public void encdoe() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("zww");
        bean.setAge(18);
        byte[] bytes = encoder.encode(bean);
        assertNotNull(bytes);
    }
}
