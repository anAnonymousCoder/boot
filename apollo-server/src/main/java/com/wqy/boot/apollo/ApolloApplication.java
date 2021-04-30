package com.wqy.boot.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
@EnableFeignClients(basePackages = {"com.wqy.boot.common.client"})
@EnableEurekaClient
public class ApolloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloApplication.class);
    }
}
