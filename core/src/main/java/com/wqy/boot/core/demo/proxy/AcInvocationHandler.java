package com.wqy.boot.core.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AcInvocationHandler<T> implements InvocationHandler {

    public T target;

    public AcInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行[" + method.getName() + "]方法");
        method.invoke(target, args);
        System.out.println("空调定时关闭");
        return null;
    }
}
