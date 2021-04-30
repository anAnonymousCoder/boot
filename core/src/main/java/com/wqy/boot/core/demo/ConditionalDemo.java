package com.wqy.boot.core.demo;

import com.wqy.boot.core.domain.entity.Cat;
import com.wqy.boot.core.domain.entity.Master;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 条件装配注解：只有满足条件时才给容器中注入bean
 * 包括@Conditional，@ConditionalOnBean，@ConditionalOnClass等注解
 */
@Configuration
public class ConditionalDemo {

    /**
     * 只有在容器中有Cat类型的组件时才会注册masterConfig
     * 当这个注解放在配置类上时，整个配置类都不会注册到容器中
     *
     * @return Master
     */
    @ConditionalOnBean({Cat.class})
    @Bean
    public Master masterConfig() {
        Master master = new Master();
        // masterConfig依赖了catConfig
        master.setPet(catConfig());
        return master;
    }

    public Cat catConfig() {
        return new Cat();
    }
}
