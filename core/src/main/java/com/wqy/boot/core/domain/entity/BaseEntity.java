package com.wqy.boot.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类，封装公用的id和时间戳等属性
 * 实体父类
 * 序列化时忽略懒加载属性，避免报错
 *
 * @author wqy
 * @version 1.0 2020/10/9
 */

@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public abstract class BaseEntity implements Serializable {

    private String id;

    // private Integer deleteFlag;

    private Date createAt;

    private Date updateAt;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false, unique = true, updatable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    @Column(nullable = false, length = 32, columnDefinition = "int default 0")
//    public Integer getDeleteFlag() {
//        return deleteFlag;
//    }
//
//    public void setDeleteFlag(Integer deleteFlag) {
//        this.deleteFlag = deleteFlag;
//    }

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(nullable = false)
    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
