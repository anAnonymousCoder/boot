package com.wqy.boot.core.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录成功处理逻辑
 *
 * @author wqy
 * @version 1.0 2020/1/6
 */
@Component
public class WsAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 打印详细认证信息
        logger.info("Authentication succeeded, detail: {}", authentication.toString());
        response.setContentType("application/json;charset=utf-8");
        // 跳转到登录之前请求的页面
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
