package com.zk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Test06_JDKProxy {
    public static void main(String[] args) {
        UserServiceImpl userService1 = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService1);
        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), new Class[]{UserService.class}, myInvocationHandler);
        List<String> list = userServiceProxy.list();
        System.out.println(list);
    }
}

class MyInvocationHandler implements InvocationHandler {
    Object target;
    public MyInvocationHandler(Object obj) {
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        System.out.println("methodName before"+ name);
        Object res = method.invoke(target, args);
        System.out.println("methodName after"+ name);
        return res;
    }
}

interface UserService{
    List<String> list();
}

class UserServiceImpl implements UserService {

    @Override
    public List<String> list() {
        List<String> list = new ArrayList<>();
        list.add("lmz");
        list.add("lbw");
        return list;
    }
}
