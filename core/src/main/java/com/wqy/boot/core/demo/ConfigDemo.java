package com.wqy.boot.core.demo;

import com.wqy.boot.core.domain.entity.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 等于配置文件
 * - @Order可以控制配置类的加载顺序
 */
@Configuration
@Order(900)
public class ConfigDemo {

    /**
     * 给容器中添加组件，方法名称就是组件的id
     *
     * @return Cat
     */
    @Bean
    public Cat catConfig() {
        return new Cat();
    }


}
