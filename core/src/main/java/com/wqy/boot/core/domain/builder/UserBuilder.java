package com.wqy.boot.core.domain.builder;


import com.wqy.boot.common.dto.UserDTO;
import com.wqy.boot.core.domain.entity.User;
import com.wqy.boot.core.domain.security.WsUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * User和UserDTO转换类
 *
 * @author wqy
 * @version 1.0 2020/11/14
 */
public class UserBuilder {

    /**
     * 将User的属性拷贝给UserDTO
     *
     * @param user    User实体
     * @param userDTO UserDTO
     */
    private static void toDTO(User user, UserDTO userDTO) {
        if (user != null && userDTO != null) {
            // 忽略密码，前端不能取到用户的密码
            BeanUtils.copyProperties(user, userDTO, "password");
        }
    }

    /**
     * 返回拷贝属性后的UserDTO
     *
     * @param user User实体
     * @return UserDTO
     */
    public static UserDTO buildDTO(User user) {
        if (user != null) {
            UserDTO userDTO = new UserDTO();
            toDTO(user, userDTO);
            return userDTO;
        }
        return null;
    }

    /**
     * 返回拷贝属性后的UserDTO列表
     *
     * @param userList User实体列表
     * @return UserDTO列表
     */
    public static List<UserDTO> buildDTOList(List<User> userList) {
        if (CollectionUtils.isEmpty(userList)) {
            return Collections.emptyList();
        }
        List<UserDTO> userDTOList = new LinkedList<>();
        userList.forEach(user -> {
            if (user != null) {
                userDTOList.add(buildDTO(user));
            }
        });
        return userDTOList;
    }

    /**
     * 将UserDTO的属性拷贝给User
     *
     * @param userDTO UserDTO
     * @param user    User实体
     */
    private static void toEntity(UserDTO userDTO, User user, PasswordEncoder passwordEncoder) {
        if (user != null && userDTO != null && passwordEncoder != null) {
            BeanUtils.copyProperties(userDTO, user, "password");
            // 新增或修改用户密码时
            if (!StringUtils.isEmpty(userDTO.getPassword())) {
                user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }
        }
    }

    /**
     * 返回拷贝属性后的User
     *
     * @param userDTO UserDTO
     * @return User
     */
    public static User buildEntity(UserDTO userDTO, PasswordEncoder passwordEncoder) {
        if (userDTO != null) {
            User user = new User();
            toEntity(userDTO, user, passwordEncoder);
            return user;
        }
        return null;
    }

    /**
     * 返回拷贝属性后的User列表
     *
     * @param userDTOList UserDTO列表
     * @return User列表
     */
    public static List<User> buildEntityList(List<UserDTO> userDTOList, PasswordEncoder passwordEncoder) {
        if (CollectionUtils.isEmpty(userDTOList)) {
            return Collections.emptyList();
        }
        List<User> userList = new LinkedList<>();
        userDTOList.forEach(userDTO -> {
            if (userDTO != null) {
                userList.add(buildEntity(userDTO, passwordEncoder));
            }
        });
        return userList;
    }

    /**
     * @param userPage 待处理的分页结果
     * @param pageable 分页接口
     * @return 分页结果
     */
    public static Page<UserDTO> buildDTOPage(Page<User> userPage, Pageable pageable) {
        List<User> userList = userPage.getContent();
        List<UserDTO> userDTOList = new LinkedList<>();
        if (!CollectionUtils.isEmpty(userList)) {
            userList.forEach(user -> {
                if (user != null) {
                    userDTOList.add(buildDTO(user));
                }
            });
        }
        return new PageImpl<>(userDTOList, pageable, userPage.getTotalElements());
    }

    /**
     * 新建UserDetails
     *
     * @param user 用户实体
     * @return UserDetails的实现类
     */
    public static WsUserDetails buildUserDetails(User user) {
        if (user != null) {
            WsUserDetails wsUserDetails = new WsUserDetails();
            wsUserDetails.setId(user.getId());
            wsUserDetails.setUsername(user.getUsername());
            wsUserDetails.setPassword(user.getPassword());
            wsUserDetails.setNickname(user.getNickname());
            wsUserDetails.setGender(user.getGender());
            wsUserDetails.setAge(user.getAge());
            wsUserDetails.setNumber(user.getNumber());
            // 获取用户状态信息，包括启用、锁定和过期信息
            if (user.getUserStatus() != null) {
                wsUserDetails.setEnabled(user.getUserStatus().getEnabled());
                wsUserDetails.setLocked(user.getUserStatus().getLocked());
                wsUserDetails.setExpirationDate(user.getUserStatus().getExpirationDate());
            } else {
                wsUserDetails.setEnabled(0);
            }
            return wsUserDetails;
        }
        return null;
    }


}
