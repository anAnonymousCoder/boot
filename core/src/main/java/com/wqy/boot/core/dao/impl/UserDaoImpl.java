package com.wqy.boot.core.dao.impl;

import com.wqy.boot.core.dao.UserDao;
import com.wqy.boot.core.dao.repository.UserRepository;
import com.wqy.boot.core.domain.entity.User;
import org.springframework.stereotype.Repository;

/**
 * User的Repository实现
 *
 * @author wqy
 * @version 1.0 2020/10/9
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String, UserRepository<User>> implements UserDao {

    @Override
    public User findByName(String name) {
        return repo.findByName(name);
    }
}
