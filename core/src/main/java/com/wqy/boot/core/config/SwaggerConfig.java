package com.wqy.boot.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Swagger2配置
 *
 * @author wqy
 * @version 1.0 2020/12/21
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 只在开发和测试环境启用swagger，生产环境禁用
    @Value("${swagger.enable}")
    private boolean swaggerEnable;

    // 配置swagger2核心配置Docket
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnable)
                .apiInfo(apiInfo()) //文档信息
                .groupName("wqy-boot") //组名
                //通过以下方式扫描接口
                .select()
                //basePackage：指定扫描包，withClassAnnotation：扫描指定类上的注解，withMethodAnnotation：扫描指定方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.wqy.boot.core.controller"))
                //过滤路径
                .paths(PathSelectors.any())
                .build();
    }

    // 配置Swagger的信息ApiInfo
    private ApiInfo apiInfo() {
        return new ApiInfo("boot-Api",
                "boot接口文档",
                "1.0",
                "urn:tos",
                new Contact("wqy", "http://www.wuqingyu.site", "528945404@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList());
    }
}
