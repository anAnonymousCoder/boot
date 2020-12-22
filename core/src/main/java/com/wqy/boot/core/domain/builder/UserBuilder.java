package com.wqy.boot.core.domain.builder;


import com.wqy.boot.common.dto.UserDTO;
import com.wqy.boot.core.domain.entity.User;
import com.wqy.boot.core.util.EncryptionUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * User和userDTO转换类
 *
 * @author wqy
 * @version 1.0 2020/11/14
 */
public class UserBuilder {

    private UserBuilder() {

    }

    /**
     * 将user的属性拷贝给userDTO
     *
     * @param user    User实体
     * @param userDTO userDTO
     */
    private static void toDTO(User user, UserDTO userDTO) {
        if (user != null && userDTO != null) {
            //忽略密码，前端不能取到用户的密码
            BeanUtils.copyProperties(user, userDTO, "password");
        }
    }

    /**
     * 返回拷贝属性后的userDTO
     *
     * @param user User实体
     * @return userDTO
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
     * 返回拷贝属性后的userDTO列表
     *
     * @param userList User实体列表
     * @return userDTO列表
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
     * 将userDTO的属性拷贝给user
     *
     * @param userDTO userDTO
     * @param user    User实体
     */
    private static void toEntity(UserDTO userDTO, User user) {
        if (user != null && userDTO != null) {
            BeanUtils.copyProperties(userDTO, user, "password");
            //对密码进行md5加密
            user.setPassword(EncryptionUtil.encrypt(userDTO.getPassword(), "SHA"));
        }
    }

    /**
     * 返回拷贝属性后的user
     *
     * @param userDTO userDTO
     * @return User
     */
    public static User buildEntity(UserDTO userDTO) {
        if (userDTO != null) {
            User user = new User();
            toEntity(userDTO, user);
            return user;
        }
        return null;
    }

    /**
     * 返回拷贝属性后的user列表
     *
     * @param userDTOList userDTO列表
     * @return User列表
     */
    public static List<User> buildEntityList(List<UserDTO> userDTOList) {
        if (CollectionUtils.isEmpty(userDTOList)) {
            return Collections.emptyList();
        }
        List<User> userList = new LinkedList<>();
        userDTOList.forEach(userDTO -> {
            if (userDTO != null) {
                userList.add(buildEntity(userDTO));
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


}
