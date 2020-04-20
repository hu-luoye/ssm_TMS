package com.luoye_ssm.dao;

import com.luoye_ssm.domain.Role;
import com.luoye_ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户登录dao层
 */
@Repository("userDao")
public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.luoye_ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    /**
     * 查找全部用户
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 添加用户
     * @param userInfo
     * @throws Exception
     */
    @Insert("insert into users (username,password,email,phoneNum,status) values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 根据id查找用户详情
     * @param id
     * @return
     */
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.luoye_ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(int id);

    /**
     * 查找其余的角色
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRole(int userId);

    @Select("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);
}
