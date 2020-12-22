package com.wqy.boot.core.controller.rest;


import com.wqy.boot.common.dto.ResultDTO;
import com.wqy.boot.common.dto.UserDTO;
import com.wqy.boot.core.service.UserService;
import com.wqy.boot.core.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 用来将json/xml数据发送到前台页面，而不是返回视图页面
 *
 * @author wqy
 * @version 1.0 2020/10/9
 */

@Api(tags = {"用户Controller"})
@RestController
@RequestMapping("/rest/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     *
     * @param userDTO 用户实体
     * @return 新增的用户
     */
    @ApiOperation(value = "新增用户")
    @PostMapping(value = "/create", consumes = {"application/json"})
    public ResultDTO<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    /**
     * 通过id查找用户
     *
     * @param id 用户id
     * @return 查找到的用户
     */
    @ApiOperation(value = "通过id查找用户")
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable(name = "id") String id) {
        return userService.findUserById(id);
    }

    /**
     * 通过name查找用户
     *
     * @param name 用户name
     * @return 查找到的用户
     */
    @ApiOperation(value = "通过name查找用户")
    @PostMapping("/{name}")
    public UserDTO findByName(@PathVariable(name = "name") String name) {
        return userService.findUserByName(name);
    }

    /**
     * 登录验证
     *
     * @param name     用户名
     * @param password 密码
     * @return 登录结果
     */
    @ApiOperation(value = "用户登录")
    @GetMapping("/login")
    public ResultDTO<UserDTO> login(@RequestParam(name = "name") String name,
                                    @RequestParam(name = "password") String password) {
        return userService.checkLogin(name, password);
    }

    /**
     * 用户记录分页显示
     *
     * @param page  当前页码
     * @param limit 每页记录数
     * @return 分页记录
     */
    @ApiOperation(value = "用户记录分页显示")
    @GetMapping("/page")
    public PageVO<UserDTO> page(@RequestParam(name = "page") int page,
                                @RequestParam(name = "limit") int limit) {
        PageRequest pageRequest = PageRequest.of(page - 1, limit);
        Page<UserDTO> userDTOPage = userService.page(pageRequest);
        return new PageVO<>(userDTOPage.getTotalElements(), userDTOPage.getContent());
    }

}
