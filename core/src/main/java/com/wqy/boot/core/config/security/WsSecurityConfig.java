package com.wqy.boot.core.config.security;

import com.wqy.boot.core.service.WsUserDetailsService;
import com.wqy.boot.core.util.WsPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Spring Security配置
 *
 * @author wqy
 * @version 1.0 2020/12/24
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WsSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WsSecurityConfig.class);

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
     * 认证成功事件
     *
     * @return AuthenticationSuccessHandler
     * @see WsAuthenticationSuccessHandler
     */
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new WsAuthenticationSuccessHandler();
    }

    /**
     * 认证失败事件
     *
     * @return AuthenticationFailureHandler
     * @see WsAuthenticationFailureHandler
     */
    @Bean
    public AuthenticationFailureHandler failureHandler() {
        return new WsAuthenticationFailureHandler();
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
     * 认证授权规则
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity)");
        // 首页所有人可以访问
        http.authorizeRequests()
                // 允许所有人访问登录页面和注册页面
                .antMatchers("/login", "/formRegister", "/rest/user/**")
                .permitAll()
                // 允许ADMIN角色访问用户管理页
                // .antMatchers("/admin/**")
                // .hasRole("ADMIN")
                // 除了前面定义过的url，访问其他url都必须先认证（登录后访问）
                .anyRequest()
                .authenticated()
                // 开启表单登录
                .and()
                .formLogin()
                // 自定义的登录页
                .loginPage("/login")
                // 登录页表单请求路径
                .loginProcessingUrl("/formLogin")
                // 默认登录成功跳转路径，如果已经配置了successHandler则不用配置
                // .defaultSuccessUrl("/admin/user-manage")
                // 自定义登录成功逻辑
                .successHandler(successHandler())
                // 自定义登录失败逻辑
                .failureHandler(failureHandler())
                // 关闭跨站请求伪造防护
                .and()
                .csrf()
                .disable();

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        http.logout()
                // 注销功能
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");

        // 记住我
        http.rememberMe().key("HelloWorld");
    }

    /**
     * 认证规则
     *
     * <p>密码必须经过加密，在Spring Security 5中新增了加密方式<br>
     * 通过 {@link WsUserDetailsService#loadUserByUsername(String)} 方法进行身份验证
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
                "/swagger-resources/**", "/v2/**", "/**.ico", "/swagger-ui.html");
    }
}
