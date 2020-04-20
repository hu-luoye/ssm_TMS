package com.luoye_ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 回显时间
 */
@Controller
@RequestMapping("/hello")
public class HelloHandler {

    @RequestMapping("/time")
    public ModelAndView getTime(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("hello");
        ModelAndView modelAndView = new ModelAndView();
        Cookie[] cookies = request.getCookies();
        //如果cookie为空，自己创建一个
        if (request.getCookies() == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String time = simpleDateFormat.format(new Date());
            //存入cookie
            Cookie cookie = new Cookie("lastTime",time);
            cookie.setMaxAge(7*24*3600); //设定保存的最长时间
            response.addCookie(cookie);  //服务器返回给客户端
        }
        //cookie有值
        if (request.getCookies() != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastTime")) {
                    //取出时间,放入域中
                    String lastTime = cookie.getValue();
                   modelAndView.addObject("lastTime",lastTime);
                    //再重新设置cookie
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String time = simpleDateFormat.format(new Date());
                    //存入cookie
                    Cookie newCookie = new Cookie("lastTime",time);
                    cookie.setMaxAge(7*24*3600); //设定保存的最长时间
                    response.addCookie(cookie);  //服务器返回给客户端
                }
            }
        }
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
