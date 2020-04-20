package com.luoye_ssm.controller;

import org.springframework.stereotype.Component;

@Component("test")
public class TestAop {
    public void print() {
        System.out.println("hello");
    }
}
