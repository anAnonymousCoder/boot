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

    ResultDTO<UserDTO> saveUser(UserDTO userDTO);

    UserDTO findUserById(String id);

    UserDTO findUserByName(String name);

    ResultDTO<UserDTO> checkLogin(String name, String password);

    Page<UserDTO> page(Pageable pageable);
}
