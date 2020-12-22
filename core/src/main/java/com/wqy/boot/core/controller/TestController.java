package com.wqy.boot.core.controller;

import com.wqy.boot.core.domain.entity.Dog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/test")
@Api(tags = {"测试接口"})
public class TestController {

    @Autowired
    private Dog dog;

    @ApiOperation(value = "test1")
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public Dog test1() {
        return dog;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public Dog test2() {
        return dog;
    }
}
