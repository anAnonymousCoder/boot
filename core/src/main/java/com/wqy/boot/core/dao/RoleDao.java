package com.wqy.boot.core.dao;

import com.wqy.boot.core.dao.repository.RoleRepository;
import com.wqy.boot.core.domain.entity.Role;

/**
 * RoleDao继承了BaseDao中的方法，并可以实现特有的方法
 *
 * @author wqy
 * @version 1.0 2020/12/29
 */
public interface RoleDao extends BaseDao<Role, String, RoleRepository<Role>> {
}
