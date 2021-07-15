package com.wqy.boot.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wqy
 * @version 1.0 2020/12/28
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAspectJAutoProxy(exposeProxy = true)
public class CoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
