package com.bj186.oa.controller;

import com.bj186.oa.exception.NullNameException;
import com.bj186.oa.pojo.User;
import com.bj186.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }
    @RequestMapping("/selectById")
    @ResponseBody
    public User selectById(@RequestBody User user){
        user = userService.selectUserById2(user.getuID());
        return user;
    }
    @RequestMapping("/getVar/{id}/{name}")
    public String getVar(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "user/login";
    }
    @RequestMapping("/ajax")
    @ResponseBody
    public List<User> ajax(@RequestBody User user) throws NullNameException {
        List<User> users = new ArrayList<>();
        if (user.getUsername().equals("")){
            throw new NullNameException("用户名不能为空！");
        }else {
            System.out.println(user.getUsername());
            user.setPassword("666");
            users.add(user);
            users.add(user);
        }
        return users;
    }
    @ExceptionHandler(NullNameException.class)
    @ResponseBody
    public NullNameException check(NullNameException e) {
        System.out.println("捕获异常！");
        return e;
    }
}
