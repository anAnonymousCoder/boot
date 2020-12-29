package com.wqy.boot.core.service.impl;

import com.wqy.boot.common.dto.ResultDTO;
import com.wqy.boot.common.dto.RoleDTO;
import com.wqy.boot.core.dao.RoleDao;
import com.wqy.boot.core.domain.builder.RoleBuilder;
import com.wqy.boot.core.domain.entity.Role;
import com.wqy.boot.core.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RoleService接口实现
 *
 * @author wqy
 * @version 1.0 2020/12/29
 */
@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    /**
     * 保存角色
     *
     * @param roleDTO 角色数据传输对象
     * @return 操作结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<RoleDTO> saveRole(RoleDTO roleDTO) {
        Role role = RoleBuilder.buildEntity(roleDTO);
        RoleDTO record = RoleBuilder.buildDTO(roleDao.save(role));
        return new ResultDTO<>(ResultDTO.ResultCode.SUCCESS.getCode(), "Added successfully", record);
    }
}
