package com.wqy.boot.core.dao;


import com.wqy.boot.core.dao.repository.UserRepository;
import com.wqy.boot.core.domain.entity.User;

/**
 * UserDao继承了BaseDao中的方法，并可以实现特有的方法
 *
 * @author wqy
 * @version 1.0 2020/10/9
 */
public interface UserDao extends BaseDao<User, String, UserRepository<User>> {

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户实体对象
     */
    User findByUsername(String username);

}
