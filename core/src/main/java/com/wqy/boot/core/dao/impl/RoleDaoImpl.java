package com.wqy.boot.core.dao.impl;

import com.wqy.boot.core.dao.RoleDao;
import com.wqy.boot.core.dao.repository.RoleRepository;
import com.wqy.boot.core.domain.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Role的Repository实现
 *
 * @author wqy
 * @version 1.0 2020/12/29
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, String, RoleRepository<Role>> implements RoleDao {
}
