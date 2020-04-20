package com.luoye_ssm.domain;

import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * 用户角色
 */
public class Role {
    private int id;
    private String roleName;
    private String roleDesc;
    private List<User> users;
    private List<Permission> pemissions;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                ", pemissions=" + pemissions +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Permission> getPemissions() {
        return pemissions;
    }

    public void setPemissions(List<Permission> pemissions) {
        this.pemissions = pemissions;
    }
}
