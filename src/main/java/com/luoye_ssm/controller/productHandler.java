package com.luoye_ssm.controller;

import com.github.pagehelper.PageInfo;
import com.luoye_ssm.domain.Product;
import com.luoye_ssm.service.IProductService;
import com.luoye_ssm.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * 商品控制层
 */
@Controller
@RequestMapping("/product")
public class productHandler {

    @Autowired
    private IProductService productService;


    //查找全部产品
    @RequestMapping("/findAll/{page}/{size}")
//    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@PathVariable int page,@PathVariable int size) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Product> ps = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(ps);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    //添加产品
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        product.setDepartureTime(DateUtils.stringToDate(product.getDepartureTimeStr(), "yyyy-MM-dd"));
        productService.save(product);
        return "redirect:findAll/1/5";
    }
}
