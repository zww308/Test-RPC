package com.zww.testrpc.common.utils;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author zww
 * @date 2021/2/7 14:59
 */


public class ReflectionUtilsTest {


    @Test
    public void newInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);
    }

    @Test
    public void getPiblicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1,methods.length);
         String mname = methods[0].getName();
         assertEquals("b",mname);
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];
        
        TestClass t = new TestClass();
        Object invoke = ReflectionUtils.invoke(t, b);
        assertEquals("b",invoke);
    }
}
