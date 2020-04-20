package com.luoye_ssm.service;

import com.luoye_ssm.domain.Role;
import com.luoye_ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 用户接口类
 */
public interface IUserService extends UserDetailsService {

    //查找全部用户
    List<UserInfo> findAll(int page,int size) throws Exception;

    //保存用户
    void save(UserInfo userInfo) throws Exception;

    //根据id查询用户
    UserInfo findById(int id) throws Exception;

    //根据id查询未添加的角色
    List<Role> findOtherRole(int userId) throws Exception;

    //添加给用户角色
    void addRoleToUser(int id, int[] ids) throws Exception;
}
