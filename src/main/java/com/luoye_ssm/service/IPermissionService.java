package com.luoye_ssm.service;

import com.luoye_ssm.domain.Permission;

import java.util.List;

/**
 * 权限业务层接口
 */
public interface IPermissionService {

    List<Permission> findAll(int page, int size) throws Exception;

    void save(Permission permission);
}
