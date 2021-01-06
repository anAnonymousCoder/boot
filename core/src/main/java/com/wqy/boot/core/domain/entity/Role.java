package com.wqy.boot.core.domain.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

/**
 * 角色实体类
 *
 * @author wqy
 * @version 1.0 2020/12/27
 */
@Entity
@Table(name = "role_tbl")
public class Role extends BaseEntity {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色别名
     */
    private String alias;

    /**
     * 关联的用户
     */
    private List<User> users;

    /**
     * 关联的资源
     */
    private List<Resource> resources;

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 由User维护，mappedBy表示声明自己不是多对多的关系维护端，由对方来维护
     */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    @JoinTable(name = "role_resource_ref_tbl",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "id")})
    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
