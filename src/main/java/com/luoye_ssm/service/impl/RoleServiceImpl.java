package com.luoye_ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.luoye_ssm.dao.IRoleDao;
import com.luoye_ssm.domain.Permission;
import com.luoye_ssm.domain.Role;
import com.luoye_ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleServie")
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao roleDao;

    @Override
    public List<Role> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(int roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(int roleId) throws Exception {
        return roleDao.findOtherPermissionByRoleId(roleId);
    }

    @Override
    public void addPermissionToRole(int roleId, int[] ids) {
        for (int permissionId : ids) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public Role findAllPermissionByRoleId(int roleId) throws Exception {
        return roleDao.findAllPermissionByRoleId(roleId);
    }
}
