package com.wqy.boot.core.domain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 保存登录状态
 *
 * @author wqy
 * @version 1.0 2020/12/29
 */
@Entity
@Table(name = "user_status_tbl")
public class UserStatus extends BaseEntity {

    /**
     * 锁定状态
     * 1：被锁定，0：未被锁定
     */
    private Integer locked = 0;

    /**
     * 禁用标识
     * 1：启用，0：禁用
     */
    private Integer enabled = 1;

    /**
     * 失效日期
     */
    private Date expirationDate;

    /**
     * 关联用户，双向一对一
     */
    private User user;

    @Column(name = "locked", nullable = false, columnDefinition = "int default 0")
    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    @Column(name = "enabled", nullable = false, columnDefinition = "int default 1")
    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expirationDate")
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @OneToOne(mappedBy = "userStatus")
    @PrimaryKeyJoinColumn
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "locked=" + locked +
                ", enabled=" + enabled +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
