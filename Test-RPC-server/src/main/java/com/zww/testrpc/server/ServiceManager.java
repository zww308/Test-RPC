package com.zww.testrpc.server;

import com.zww.testrpc.Request;
import com.zww.testrpc.ServiceDescriptor;
import com.zww.testrpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理rpc暴露的服务：注册服务，查找服务
 * @author zww
 * @date 2021/2/7 16:43
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor,ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }
    //注册
    //扫描方法与bean绑定放在map中
    public <T> void register(Class<T> interfaceClass,T bean){
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean,method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass,method);
            services.put(sdp,sis);
            log.info("register service:{}{}",sdp.getClazz(),sdp.getMethod());
        }
    }

    //查找
    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}
