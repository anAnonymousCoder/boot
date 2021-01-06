package com.wqy.boot.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * 资源类
 *
 * @author wqy
 * @version 1.0 2021/1/2
 */
@Entity
@Table(name = "resource_tbl")
public class Resource extends BaseEntity {

    private String name;

    private String url;

    private String method;

    private List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToMany(mappedBy = "resources", fetch = FetchType.LAZY)
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
