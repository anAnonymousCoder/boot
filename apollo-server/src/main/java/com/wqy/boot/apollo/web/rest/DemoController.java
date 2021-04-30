package com.wqy.boot.apollo.web.rest;

import com.wqy.boot.common.client.DemoClient;
import com.wqy.boot.common.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/demo")
public class DemoController {

    @Autowired
    private DemoClient demoClient;

    @RequestMapping(method = RequestMethod.GET)
    public UserDTO findByUsername(@RequestParam(name = "username") String username) {
        return demoClient.findByUsername(username);
    }

}
