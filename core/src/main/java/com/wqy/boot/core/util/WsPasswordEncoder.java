package com.wqy.boot.core.util;

import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 自定义密码加密工具，实现Spring Security的接口
 *
 * @author wqy
 * @version 1.0 2020/11/13
 */
public class WsPasswordEncoder implements PasswordEncoder {

    private PasswordEncoder passwordEncoder;

    public WsPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 加密算法
     *
     * @param rawPassword 原密码
     * @return 加密后的密码
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * 匹配输入的密码和加密后的密码
     *
     * @param rawPassword     原密码
     * @param encodedPassword 加密后的密码
     * @return 比较结果
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }


}
