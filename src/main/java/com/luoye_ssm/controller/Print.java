package com.luoye_ssm.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Print {

    @Before("execution(* com.luoye_ssm.controller.*.*(..))")
    public void beg() {
        System.out.println("befort...");
    }

    @After("execution(* com.luoye_ssm.controller.*.*(..))")
    public void atfter() {
        System.out.println("after");
    }
}
