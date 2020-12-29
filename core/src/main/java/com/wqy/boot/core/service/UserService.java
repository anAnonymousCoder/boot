package com.wqy.boot.core.service;

import com.wqy.boot.common.dto.ResultDTO;
import com.wqy.boot.common.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * UserService接口
 *
 * @author wqy
 * @version 1.0 2020/10/9
 */
public interface UserService {

    /**
     * 保存用户
     *
     * @param userDTO 用户对象
     * @return 保存后的用户对象
     */
    ResultDTO<UserDTO> saveUser(UserDTO userDTO);

    /**
     * 通过id查找用户
     *
     * @param id 用户id
     * @return 用户对象
     */
    UserDTO findById(String id);

    /**
     * 通过name查找用户
     *
     * @param username 用户name
     * @return 用户对象
     */
    UserDTO findByUsername(String username);

    /**
     * 用户登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @return 查找结果
     */
    ResultDTO<UserDTO> checkLogin(String username, String password);

    /**
     * 分页查询用户信息
     *
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<UserDTO> page(Pageable pageable);
}
