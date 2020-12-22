package com.wqy.boot.core.service.impl;

import com.wqy.boot.common.dto.ResultDTO;
import com.wqy.boot.common.dto.UserDTO;
import com.wqy.boot.core.dao.UserDao;
import com.wqy.boot.core.dao.specification.UserSpecification;
import com.wqy.boot.core.domain.builder.UserBuilder;
import com.wqy.boot.core.domain.entity.User;
import com.wqy.boot.core.service.UserService;
import com.wqy.boot.core.util.EncryptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


/**
 * UserService实现类
 *
 * @author wqy
 * @version 1.0 2020/10/9
 */

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * 保存用户
     *
     * @param userDTO 用户对象
     * @return 保存后的用户对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<UserDTO> saveUser(UserDTO userDTO) {
        User user = UserBuilder.buildEntity(userDTO);
        UserDTO record = UserBuilder.buildDTO(userDao.save(user));
        return new ResultDTO<>(ResultDTO.ResultCode.SUCCESS.getCode(), "Added successfully", record);
    }

    /**
     * 通过id查找用户
     *
     * @param id 用户id
     * @return 用户对象
     */
    @Override
    public UserDTO findUserById(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        } else {
            User user = userDao.findById(id);
            if (user == null) {
                logger.warn("User not found, id:{}", id);
                return null;
            } else {
                return UserBuilder.buildDTO(userDao.findById(id));
            }
        }
    }

    /**
     * 通过name查找用户
     *
     * @param name 用户name
     * @return 用户对象
     */
    @Override
    public UserDTO findUserByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        } else {
            User user = userDao.findById(name);
            if (user == null) {
                logger.warn("User not found, name:{}", name);
                return null;
            } else {
                return UserBuilder.buildDTO(userDao.findById(name));
            }
        }
    }

    /**
     * 用户登录验证
     *
     * @param name     用户名
     * @param password 密码
     * @return 查找结果
     */
    @Override
    public ResultDTO<UserDTO> checkLogin(String name, String password) {
        User user = userDao.findByName(name);
        if (user == null) {
            logger.warn("User not found, name:{}", name);
            return new ResultDTO<>(ResultDTO.ResultCode.WARNING.getCode(), "User not found");
        }
        if (EncryptionUtil.equals(password, user.getPassword(), "SHA")) {
            return new ResultDTO<>(ResultDTO.ResultCode.SUCCESS.getCode(), "Login Success");
        } else {
            logger.warn("Password mismatch, name:{}", name);
            return new ResultDTO<>(ResultDTO.ResultCode.FAILURE.getCode(), "Password mismatch");
        }
    }

    /**
     * 分页查询用户信息
     *
     * @param pageable 分页参数
     * @return 分页结果
     */
    @Override
    public Page<UserDTO> page(Pageable pageable) {
        UserSpecification userSpecification = new UserSpecification();
        Page<User> userPage = userDao.page(pageable, userSpecification);
        return UserBuilder.buildDTOPage(userPage, pageable);
    }
}
