package com.wqy.boot.core.demo;

import com.wqy.boot.core.domain.entity.Dog;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

/**
 * “@Import"注解可以导入新的组件
 * 可以给容器中自动创建出import的组件
 * 主要用于将第三方的组件注入到spring容器中
 * <p>
 * "@Import"的三种用法主要包括：
 * 1、直接填class数组方式
 * - @Import({ 类名.class , 类名.class... })
 * 2、ImportSelector方式【重点】
 * 3、ImportBeanDefinitionRegistrar方式
 */
@Import({Dog.class})
@Configuration
@Order(999)
public class ImportDemo {


}
