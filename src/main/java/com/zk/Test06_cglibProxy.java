package com.zk;

import org.springframework.aop.TargetSource;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test06_cglibProxy {
    public static void main(String[] args) {
        UserService userService = (UserService)MyCglibProxy.getObject(UserServiceImpl.class);
        List<String> list = userService.list();
        System.out.println(list);
    }

}

class TargetInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object res = methodProxy.invokeSuper(obj, args);
        System.out.println("调用后");
        return res;
    }
}

class MyCglibProxy {
    public static Object getObject(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new TargetInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
