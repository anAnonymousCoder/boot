package com.wqy.boot.core.demo.proxy;

public class AirConditioner implements Appliance {

    public void work (int hour) {
        System.out.println("空调制冷" + hour + "小时");
    }
}
