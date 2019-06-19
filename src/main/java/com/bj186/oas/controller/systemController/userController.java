package com.bj186.oas.controller.systemController;

import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;
    @RequestMapping("/select")
    @ResponseBody
    public Staff selectStaffAll() {
        return userService.selectByPrimaryKey(10001);
    }

}
