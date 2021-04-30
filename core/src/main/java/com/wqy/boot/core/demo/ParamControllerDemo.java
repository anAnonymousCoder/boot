package com.wqy.boot.core.demo;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamControllerDemo {


    /**
     * "@PathVariable"获取路径变量
     * "@RequestHeader"获取请求头
     * "@CookieValue"获取cookie
     * "@RequestAttribute"获取request请求域
     *
     * @return String
     */
    @RequestMapping(value = "/param/{1}/{2}")
    public String param(@RequestHeader(name = "User-Agent") String userAgent) {
        return null;
    }
}
