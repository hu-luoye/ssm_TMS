package com.luoye_ssm.controller;

import com.github.pagehelper.PageInfo;
import com.luoye_ssm.domain.Role;
import com.luoye_ssm.domain.UserInfo;
import com.luoye_ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    IUserService userService;

    @RequestMapping("/findAll/{page}/{size}")
    public ModelAndView findAll(@PathVariable int page,@PathVariable int size) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userList = userService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(userList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    //添加用户
    @RequestMapping("/save")
    public String save( UserInfo userInfo) throws Exception {
        if (userInfo.getStatusStr().equals("开启")) userInfo.setStatus(1);
        else userInfo.setStatus(0);
        userService.save(userInfo);
        return "redirect:findAll/1/5";
    }

    //查找指定id的用户
    @RequestMapping("findById/{id}")
    public ModelAndView findById(@PathVariable int id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    //查询用户回显添加的角色
    @RequestMapping("/findUserAndAllRole/{id}")
    public ModelAndView findUserAndAllRole(@PathVariable("id") int userId) throws Exception {
        //根据id查询用户
        UserInfo userInfo = userService.findById(userId);
        //根据id查询可以添加的角色
        List<Role> roleList = userService.findOtherRole(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    //添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) int userId,@RequestParam(name = "ids",required = true) int[] ids) throws Exception {
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll/1/5";
    }
}
