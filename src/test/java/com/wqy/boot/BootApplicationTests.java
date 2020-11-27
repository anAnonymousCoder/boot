package com.wqy.boot;

import com.wqy.boot.domain.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootApplicationTests {

    @Autowired
    Dog dog;

    @Test
    public void contextLoads() {
        System.out.println(dog);
    }

}
