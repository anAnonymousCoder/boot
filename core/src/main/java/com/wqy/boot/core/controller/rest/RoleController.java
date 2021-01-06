package com.wqy.boot.core.controller.rest;

import com.wqy.boot.common.dto.ResultDTO;
import com.wqy.boot.common.dto.RoleDTO;
import com.wqy.boot.core.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用来将json/xml数据发送到前台页面，而不是返回视图页面
 *
 * @author wqy
 * @version 1.0 2020/12/29
 */

@Api(value = "RoleController", tags = {"角色接口"})
@RestController
@RequestMapping("/rest/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "新增角色")
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResultDTO<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO) {
        return roleService.saveRole(roleDTO);
    }
}
