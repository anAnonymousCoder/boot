package com.wqy.boot.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转Controller，一般只用于视图解析，不发送json等数据
 *
 * @author wqy
 * @version 1.0 2020/10/9
 */

@Controller
@RequestMapping
public class IndexController {


    @GetMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("/users/user-manage")
    public String userManage() {
        return "/user-manage";
    }

}
