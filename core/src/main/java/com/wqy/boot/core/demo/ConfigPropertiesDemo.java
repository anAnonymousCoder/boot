package com.wqy.boot.core.demo;


import com.wqy.boot.core.domain.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置绑定：读取properties文件内容，转化为bean以供使用
 * "@EnableConfigurationProperties"注解的功能：
 * 1. 开启属性配置功能
 * 2. 把指定的组件注册到容器中
 *
 * 可以用@ConfigurationProperties() + @Component进行替换
 */
@Configuration
@EnableConfigurationProperties({Cat.class})
public class ConfigPropertiesDemo {

    @Qualifier("animal.cat-com.wqy.boot.core.domain.entity.Cat")
    @Autowired
    Cat cat;

}
