package com.wqy.boot.core.service.demo;

import com.wqy.boot.common.dto.UserDTO;
import com.wqy.boot.core.dao.UserDao;
import com.wqy.boot.core.domain.builder.UserBuilder;
import com.wqy.boot.core.domain.entity.User;
import org.hibernate.annotations.common.util.impl.Log_$logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TransactionB {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void addUser(UserDTO userDTO) {
        User user = UserBuilder.buildEntity(userDTO, passwordEncoder);
        try {
            UserBuilder.buildDTO(userDao.save(user));
        } catch (Exception e) {

        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public UserDTO addUserException(UserDTO userDTO) {
        User user = UserBuilder.buildEntity(userDTO, passwordEncoder);
        UserDTO record = UserBuilder.buildDTO(userDao.save(user));
        System.out.println(1 / 0);
        return record;
    }


}
