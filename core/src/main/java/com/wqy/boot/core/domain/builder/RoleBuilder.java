package com.wqy.boot.core.domain.builder;

import com.wqy.boot.common.dto.RoleDTO;
import com.wqy.boot.core.domain.entity.Role;
import org.springframework.beans.BeanUtils;

/**
 * Role和RoleDTO转换类
 *
 * @author wqy
 * @version 1.0 2020/11/14
 */
public class RoleBuilder {

    /**
     * 将Role的属性拷贝给RoleDTO
     *
     * @param role    角色实体
     * @param roleDTO RoleDTO
     */
    private static void toDTO(Role role, RoleDTO roleDTO) {
        if (role != null && roleDTO != null) {
            BeanUtils.copyProperties(role, roleDTO);
        }
    }

    /**
     * 返回拷贝属性后的RoleDTO
     *
     * @param role Role实体
     * @return RoleDTO
     */
    public static RoleDTO buildDTO(Role role) {
        if (role != null) {
            RoleDTO roleDTO = new RoleDTO();
            toDTO(role, roleDTO);
            return roleDTO;
        }
        return null;
    }

    /**
     * 将RoleDTO的属性拷贝给Role
     *
     * @param roleDTO RoleDTO
     * @param role    Role实体
     */
    private static void toEntity(RoleDTO roleDTO, Role role) {
        if (role != null && roleDTO != null) {
            BeanUtils.copyProperties(roleDTO, role);
        }
    }

    /**
     * 返回拷贝属性后的Role
     *
     * @param roleDTO RoleDTO
     * @return Role实体
     */
    public static Role buildEntity(RoleDTO roleDTO) {
        if (roleDTO != null) {
            Role role = new Role();
            toEntity(roleDTO, role);
            return role;
        }
        return null;
    }


}
