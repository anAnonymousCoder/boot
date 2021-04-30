package com.wqy.boot.core.domain.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 没有使用@component注解注册到容器中
 * 可以使用@EnableConfigurationProperties注解注入到容器中，该注解必须写在配置类上
 */
@ConfigurationProperties(prefix = "animal.cat")
public class Cat extends Pet {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
