package com.wqy.boot.core.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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


    @GetMapping({"/", "/login"})
    public String index() {
        return "login";
    }

    @GetMapping("/admin/user-manage")
    @PreAuthorize("hasRole('ADMIN')")
    public String userManage() {
        return "/admin/user-manage";
    }



}
