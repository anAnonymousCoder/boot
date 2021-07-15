package com.wqy.boot.core.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        InvocationHandler invocationHandler = new AcInvocationHandler<>(airConditioner);
        Appliance proxy = (Appliance) Proxy.newProxyInstance(AirConditioner.class.getClassLoader(), AirConditioner.class.getInterfaces(), invocationHandler);
        proxy.work(2);
    }
}
