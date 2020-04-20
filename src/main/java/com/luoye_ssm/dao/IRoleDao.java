package com.luoye_ssm.dao;

import com.luoye_ssm.domain.Permission;
import com.luoye_ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用户角色dao
 */
public interface IRoleDao {

    //根据用户id查询所有角色
    @Select("SELECT * from role WHERE id in (SELECT roleId FROM users_role WHERE userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "pemissions",column = "id",javaType = List.class,many = @Many(select = "com.luoye_ssm.dao.IPermissionsDao.findPermsisionByRoleId")),
    })
    public List<Role> findRoleByUserId(int userId) throws Exception;

    /**
     * 查找全部
     */
    @Select("select * from role")
    List<Role> findAll();

    /**
     * 保存用户
     * @param role
     */
    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    /**
     * 查找角色
     * @param roleId
     * @return
     */
    @Select("select * from role where id=#{roleId}")
    Role findById(int roleId);

    /**
     * 查找未有的权限
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissionByRoleId(int roleId);

    @Select("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int permissionId);

    /**
     * 查找拥有角色并拥有的权限
     * @param roleId
     * @return
     */
    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "pemissions",column = "id",javaType = List.class,many = @Many(select = "com.luoye_ssm.dao.IPermissionsDao.findPermsisionByRoleId")),
    })
    Role findAllPermissionByRoleId(int roleId);
}
