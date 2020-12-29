package com.wqy.boot.core.domain.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现Spring Security的UserDetails接口
 *
 * @author wqy
 * @version 1.0 2020/12/28
 */
public class WsUserDetails implements UserDetails {

    /**
     * id
     */
    private String id;

    /**
     * 编号
     */
    private Integer number;

    /**
     * 姓名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 锁定状态
     * 1：被锁定，0：未被锁定
     */
    private Integer locked;

    /**
     * 禁用标识
     * 1：启用，0：禁用
     */
    private Integer enabled;

    /**
     * 失效日期
     */
    private Date expirationDate;

    /**
     * 权限列表
     */
    List<GrantedAuthority> authorities = new LinkedList<>();

    @Override
    @JsonIgnore
    public List<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * 账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return this.getExpirationDate() == null || System.currentTimeMillis() < this.getExpirationDate().getTime();
    }

    /**
     * 账号是否被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.getLocked() == 0;
    }

    /**
     * 凭证是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否被禁用
     */
    @Override
    public boolean isEnabled() {
        return this.getEnabled() == 1;
    }
}
