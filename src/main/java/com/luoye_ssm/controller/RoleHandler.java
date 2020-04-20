package com.luoye_ssm.controller;
import com.github.pagehelper.PageInfo;
import com.luoye_ssm.domain.Permission;
import com.luoye_ssm.domain.Role;
import com.luoye_ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 角色controller层
 */
@Controller
@RequestMapping("/role")
public class RoleHandler {

    @Autowired
    IRoleService roleService;

    @RequestMapping("/findAll/{page}/{size}")
    public ModelAndView findAll(@PathVariable int page,@PathVariable int size) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles= roleService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(roles);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll/1/5";
    }

    /**
     * 查找角色权限并回显
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findRoleAndAllPermission/{id}")
    public ModelAndView findRoleAndAllPermission(@PathVariable int id) throws Exception {
        Role role = roleService.findById(id);
        List<Permission> permissionList = roleService.findOtherPermission(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role",role);
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    /**
     * 添加权限到角色
     */
    @RequestMapping(value = "/addPermissionToRole")
    public String addPermissionToRole(@RequestParam("roleId") int roleId, @RequestParam("ids") int[] ids) {
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll/1/5";
    }

    @RequestMapping("/findAllPermission/{id}")
    public ModelAndView findAllPermissionByRoleId(@PathVariable("id") int roleId) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
      Role role = roleService.findAllPermissionByRoleId(roleId);
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

}
