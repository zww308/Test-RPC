package com.zww.testrpc.server;


import com.zww.testrpc.Request;
import com.zww.testrpc.ServiceDescriptor;
import com.zww.testrpc.common.utils.ReflectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author zww
 * @date 2021/2/21 13:17
 */


public class ServiceManagerTest {
    ServiceManager sm;

    @Before
    public void init(){
        sm = new ServiceManager();
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }
    @Test
    public void register() {
        TestInterface bean = new TestClass();

        sm.register(TestInterface.class,bean);
    }

    @Test
    public void lookup() {
        Method methods = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class,methods);
        Request request = new Request();
        request.setService(sdp);
        ServiceInstance serviceInstance = sm.lookup(request);
        assertNotNull(serviceInstance);

    }
}
