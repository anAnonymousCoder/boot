package com.wqy.boot.core.service;

import com.wqy.boot.common.dto.ResultDTO;
import com.wqy.boot.common.dto.RoleDTO;

/**
 * RoleService接口
 *
 * @author wqy
 * @version 1.0 2020/12/29
 */
public interface RoleService {

    /**
     * 保存角色
     *
     * @param roleDTO 角色数据传输对象
     * @return 操作结果
     */
    ResultDTO<RoleDTO> saveRole(RoleDTO roleDTO);
}
