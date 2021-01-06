package com.wqy.boot.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

/**
 * 根据用户传来的请求地址，分析出请求需要的角色
 * 权限控制基于AbstractSecurityInterceptor抽象类，子类有MethodSecurityInterceptor和FilterSecurityInterceptor等
 * Spring Security提供的两种默认方法实现权限控制：
 * 1. 在方法上使用@Secured或@PreAuthorize注解
 * 2. 在配置中以antMatchers("/xxx")等方式匹配
 * 这两种方法最终都会生成MethodSecurityInterceptor实例
 * 自定义FilterSecurityInterceptor可以实现动态配置权限
 *
 * @author wqy
 * @version 1.0 2021/1/2
 */
public class WsFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static final Logger logger = LoggerFactory.getLogger(FilterInvocationSecurityMetadataSource.class);

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) o;
        // 请求URL
        String requestUrl = filterInvocation.getRequestUrl();
        // 请求方式
        String httpMethod = filterInvocation.getRequest().getMethod();

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
