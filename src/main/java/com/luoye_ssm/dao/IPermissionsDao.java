package com.luoye_ssm.dao;

import com.luoye_ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限dao
 */
@Repository("permissionDao")
public interface IPermissionsDao {

    //根据roleId查找permission
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findPermsisionByRoleId(String roleId) throws Exception;

    //查找全部
    @Select("select * from permission")
    List<Permission> findAll();

    //保存
    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
