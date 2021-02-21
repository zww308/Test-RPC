package com.zww.testrpc.server;

import com.zww.testrpc.Request;
import com.zww.testrpc.common.utils.ReflectionUtils;

/**
 * 调用具体服务
 * @author zww
 * @date 2021/2/7 17:06
 */

public class ServiceInvoker {
    public Object invoke(ServiceInstance service,
                         Request request) {
        return ReflectionUtils.invoke(
                service.getTarget(),
                service.getMethod(),
                request.getParameters());
    }
}
