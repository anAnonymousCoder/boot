package com.wqy.boot.core.dao.repository;

import com.wqy.boot.core.domain.entity.Role;

/**
 * 继承BaseRepository
 *
 * @author wqy
 * @version 1.0 2020/12/29
 */
public interface RoleRepository<R extends Role> extends BaseRepository<R, String> {
}
