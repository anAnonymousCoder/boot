package com.wqy.boot.core.domain.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * configurationProperties：默认从全局配置文件中获取值
 * PropertySource：加载指定的配置文件；
 * Validated：开启数据校验
 * ApiModel：Swagger实体类注释，在controller中作为返回值的实体类才会被扫描到
 *
 * @author wqy
 */
@Component
@ConfigurationProperties(prefix = "dog")
@PropertySource(value = "classpath:dog.properties")
@Validated
@ApiModel("Dog实体类")
public class Dog {

    /**
     * ConfigurationProperties注解作用：
     * 将配置文件中配置的每一个属性的值，映射到这个组件中；
     * 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
     * 参数 prefix = “dog” : 将配置文件中的dog下面的所有属性一一对应
     */
    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("年龄")
    private int age;


    /**
     * 通过@Value注入固定单个属性
     */
    @Value("black")
    private String color;

    /**
     * 通过@Value注入全局yml文件中的单个属性
     */
    @Value("${pet.master}")
    private String master;

    /**
     * 通过@Value注入指定properties文件中的单个属性
     */
    @Value("${gender}")
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", master='" + master + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
