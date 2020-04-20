package com.luoye_ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.luoye_ssm.dao.IUserDao;
import com.luoye_ssm.domain.Role;
import com.luoye_ssm.domain.UserInfo;
import com.luoye_ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
   IUserDao userDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //登录
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //security自带的user
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        //加上状态
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));

        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    //查找全部user
    @Override
    public List<UserInfo> findAll(int page,int size) throws Exception {

        //设置分页
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }

    //保存用户
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(int id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRole(int userId) throws Exception{
        return userDao.findOtherRole(userId);
    }

    @Override
    public void addRoleToUser(int userId, int[] ids) throws Exception {
        for (int roleId : ids) {
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
