package com.wqy.boot.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

    @DisplayName("测试DisplayName注解")
    @Test
    void contextLoads() {
        System.out.println("test");
    }

    /*
    每个测试方法执行前都要运行
    @BeforeEach
    void startTest() {
        System.out.println("开始测试...");
    }

     */

}
