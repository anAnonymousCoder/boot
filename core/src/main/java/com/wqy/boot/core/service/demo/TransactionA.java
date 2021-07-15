package com.wqy.boot.core.service.demo;

import com.wqy.boot.common.dto.UserDTO;
import com.wqy.boot.core.dao.UserDao;
import com.wqy.boot.core.domain.builder.UserBuilder;
import com.wqy.boot.core.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TransactionA {

    @Autowired
    TransactionB bService;

    @Autowired
    TransactionA transactionA;

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(TransactionA.class);

    @Transactional(rollbackFor = Exception.class)
    public void batchAddUser() {
        UserDTO innerT1 = new UserDTO();
        innerT1.setUsername("innerT1");
        innerT1.setPassword("123456");
        UserDTO innerT2 = new UserDTO();
//        ((TransactionA) AopContext.currentProxy()).innerAddUser(innerT1);
        innerT2.setUsername("innerT2");
        innerT2.setPassword("123456");
        UserDTO res1 = innerAddUser(innerT1);
        logger.info(res1.toString());
        try {
            UserDTO res2 = UserBuilder.buildDTO(userDao.save(UserBuilder.buildEntity(innerT2, passwordEncoder)));
//            UserDTO res2 = bService.addUser(innerT1);
            logger.info(res2.toString());
//            System.out.println(1 / 0);
        } catch (Exception e) {
            logger.error("Error: ", e);
        }
//        try {
//            System.out.println(1 / 0);
//        } catch (Exception e) {
//
//        }
//        try {
//            UserDTO res2 = innerAddUser(innerT2);
//            logger.info(res2.toString());
//        } catch (Exception e) {
//            logger.error(e.getLocalizedMessage());
//        }
//        System.out.println(1 / 0);
//        try {
//            System.out.println(1 / 0);
//        } catch (Exception e) {
//
//        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public UserDTO innerAddUser(UserDTO userDTO) {
        User user = UserBuilder.buildEntity(userDTO, passwordEncoder);
        UserDTO record =  UserBuilder.buildDTO(userDao.save(user));
//        System.out.println(1 / 0);
        return record;
//        return bService.addUser(userDTO);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public UserDTO innerAddUserException(UserDTO userDTO) {
        User user = UserBuilder.buildEntity(userDTO, passwordEncoder);
        UserDTO record =  UserBuilder.buildDTO(userDao.save(user));
        System.out.println(1 / 0);
        return record;
//        return bService.addUser(userDTO);
    }

    @Transactional
    public void outerAddUser() {
        UserDTO outerT1 = new UserDTO();
        outerT1.setUsername(null);
        outerT1.setPassword("123456");
        UserDTO innerT1 = new UserDTO();
        innerT1.setUsername("innerT1");
        innerT1.setPassword("123456");
//        ((TransactionA) AopContext.currentProxy()).innerAddUser(innerT1);
        innerAddUser(innerT1);
//        try {
            bService.addUser(outerT1);
//        } catch (Exception e) {
//            logger.error(e.getLocalizedMessage());
//        }
//        logger.info(res.toString());
//        System.out.println(1 / 0);
//        return res;
    }


}
