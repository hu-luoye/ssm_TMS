package com.luoye_ssm.controller;

import com.github.pagehelper.PageInfo;
import com.luoye_ssm.domain.Order;
import com.luoye_ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 订单控制层
 */
@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    IOrderService orderService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = orderService.findAll(page,size);
        //pageinfo是一个分页bean
        PageInfo pageInfo = new PageInfo(orderList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }

    @RequestMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable int id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findById(id);
        modelAndView.addObject("order",order);
        modelAndView.setViewName("order-show");
        return modelAndView;
    }
}
