package com.wqy.boot.core.dao;


import com.wqy.boot.core.dao.repository.UserRepository;
import com.wqy.boot.core.domain.entity.User;

/**
 * UserStore继承了RepositoryStore中的方法，并可以实现特有的方法
 *
 * @author wqy
 * @version 1.0 2020/10/9
 */

public interface UserDao extends BaseDao<User, String, UserRepository<User>> {

    User findByName(String name);

}
