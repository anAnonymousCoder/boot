package com.wqy.boot.core.demo.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * aware，翻译过来是知道的，已感知的，意识到的，所以这些接口从字面意思应该是能感知到所有Aware前面的属性。
 */
public class BeanNameAwareDemo implements BeanNameAware {

    @Override
    public void setBeanName(String s) {

    }
}
