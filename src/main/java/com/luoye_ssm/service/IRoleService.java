package com.luoye_ssm.service;

import com.luoye_ssm.domain.Permission;
import com.luoye_ssm.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public interface IRoleService {
    /**
     * 查找并分页
     * @param page
     * @param size
     * @return
     */
    List<Role> findAll(int page, int size) throws Exception;

    /**
     * 添加用户
     * @param role
     */
    void save(Role role) throws Exception;

    /**
     * 根据id查找角色
     * @param id
     * @return
     */
    Role findById(int id) throws Exception;

    /**
     * 根据id查找其他权限
     * @param id
     * @return
     */
    List<Permission> findOtherPermission(int id) throws Exception;

    /**
     * 添加权限到角色
     * @param roleId
     * @param ids
     */
    void addPermissionToRole(int roleId, int[] ids);

    /**
     * 根据id查找全部信息，包括permission
     * @param roleId
     * @return
     * @throws Exception
     */
    Role findAllPermissionByRoleId(int roleId) throws Exception;
}
