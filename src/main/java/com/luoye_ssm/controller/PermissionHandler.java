package com.luoye_ssm.controller;

import com.github.pagehelper.PageInfo;
import com.luoye_ssm.domain.Permission;
import com.luoye_ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 权限controller层
 */
@Controller
@RequestMapping("/premission")
public class PermissionHandler {
    @Autowired
    IPermissionService permissionService;

    @RequestMapping("/findAll/{page}/{size}")
    public ModelAndView findAll(@PathVariable int page,@PathVariable int size) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(permissionList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Permission permission) throws Exception{
        permissionService.save(permission);
        return "redirect: findAll/1/5";
    }
}
