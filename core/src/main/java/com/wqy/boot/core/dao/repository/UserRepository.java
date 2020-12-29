package com.wqy.boot.core.dao.repository;

import com.wqy.boot.core.domain.entity.User;

/**
 * 继承BaseRepository
 *
 * @author wqy
 * @version 1.0 2020/10/9
 */
public interface UserRepository<U extends User> extends BaseRepository<U, String> {

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户实体
     */
    U findByUsername(String username);

}
