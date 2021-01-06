package com.wqy.boot.core.config;

import com.wqy.boot.core.service.WsUserDetailsService;
import com.wqy.boot.core.util.WsPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security配置
 *
 * @author wqy
 * @version 1.0 2020/12/24
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WsSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private WsUserDetailsService wsUserDetailsService;

    /**
     * 加密算法
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new WsPasswordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 角色继承，ADMIN > USER，管理员拥有用户的全部权限
     *
     * @return RoleHierarchy
     */
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
        return roleHierarchy;
    }

    /**
     * 授权规则
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问
        http.authorizeRequests()
                // 允许所有人访问首页（登录页）
                .antMatchers("/", "/index", "/swagger-ui.html")
                .permitAll()
                // 允许ADMIN角色访问用户管理页
                .antMatchers("/user/**")
                .hasRole("ADMIN")
                // 除了前面定义过的url，访问其他url都必须先认证（登录后访问）
                .anyRequest()
                .authenticated()
                // 开启表单登录
                .and()
                .formLogin()
                // 自定义的登录页
                .loginPage("/")
                // 登录页表单请求路径
                .loginProcessingUrl("/formLogin")
                // 默认登录成功跳转路径
                .defaultSuccessUrl("/user/user-manage")
                // 关闭csrf，防止攻击
                .and()
                .csrf()
                .disable();

        http.logout()
                // 注销功能
                .logoutSuccessUrl("/");

        // 记住我
        http.rememberMe().key("HelloWorld");
    }

    /**
     * 认证规则
     * 密码必须经过加密
     * 在Spring Security 5中新增了加密方式
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 自定义认证规则
        auth.userDetailsService(wsUserDetailsService);
    }

    /**
     * 配置忽略的url路径，一般用于静态文件
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/css/**", "/lib/**", "/img/**", "/fonts/**", "/webjars/**",
                "/swagger-resources/**", "/v2/**");
    }
}
