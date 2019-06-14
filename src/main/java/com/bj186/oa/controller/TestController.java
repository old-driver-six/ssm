package com.bj186.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue()
        {
            return 1;
        }
    };
    @RequestMapping("/login1")
    public String login(){
        threadLocal.set(threadLocal.get()+1);
        System.out.println("login1:"+threadLocal.get());
        threadLocal.set(threadLocal.get()+1);
        System.out.println("login1:"+threadLocal.get());
        return "/test/login2";
    }
    @RequestMapping("/login2")
    public String login2(){
        threadLocal.set(threadLocal.get()+1);
        System.out.println("login1:"+threadLocal.get());
        threadLocal.set(threadLocal.get()+1);
        System.out.println("login2:"+threadLocal.get());
        return "/test/login1";
    }
}
