package com.wqy.boot.core.controller.rest;

import com.wqy.boot.common.dto.ResultDTO;
import com.wqy.boot.core.service.SSHService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "SSHController", tags = {"SSH接口"})
@RestController
@RequestMapping("/rest/ssh")
public class SSHController {

    @Autowired
    private SSHService sshService;

    @ApiOperation(value = "执行SSH命令")
    @GetMapping("/execute")
    public ResultDTO<String> executeCmd(@RequestParam(name = "cmd") String cmd) {
        return sshService.executeCmd(cmd);
    }
}
