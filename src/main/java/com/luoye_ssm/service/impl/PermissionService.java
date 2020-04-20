package com.luoye_ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.luoye_ssm.dao.IPermissionsDao;
import com.luoye_ssm.domain.Permission;
import com.luoye_ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionService implements IPermissionService {

    @Autowired
    IPermissionsDao permissionsDao;

    @Override
    public List<Permission> findAll(int page, int size) throws Exception {
        //设置分页
        PageHelper.startPage(page,size);
        return permissionsDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionsDao.save(permission);
    }
}
