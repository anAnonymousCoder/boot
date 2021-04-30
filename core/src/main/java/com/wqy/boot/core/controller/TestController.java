package com.wqy.boot.core.controller;

import com.wqy.boot.core.domain.entity.Dog;
import com.wqy.boot.core.service.CacheService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试接口
 *
 * @author wqy
 * @version 1.0 2020/12/28
 */
@RestController
@RequestMapping("/rest/test")
@Api(value = "TestController", tags = {"测试接口"})
public class TestController {

    @Autowired
    private Dog dog;

    @Autowired
    private CacheService cacheService;

    @ApiOperation(value = "test1")
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public Dog test1() {
        return dog;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public Dog test2() {
        return dog;
    }

    @RequestMapping(value = "/setCookie", method = RequestMethod.GET)
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("Test_Cookie_Name", "Test_Cookie_Val");
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        return "Cookie添加成功！";
    }

    /**
     * 获取缓存
     *
     * @return 已缓存字符串
     */
    @GetMapping("/getCache")
    public String getCache() {
        return cacheService.getCache();
    }

    /**
     * 更新缓存
     *
     * @param cacheStr 需要缓存的字符串
     */
    @PutMapping("/updateCache")
    public void putCache(@RequestParam(name = "cacheStr") String cacheStr) {
        cacheService.updateCache(cacheStr);
    }
}
