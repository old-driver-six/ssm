package com.bj186.oas.controller;

import com.bj186.oas.mapper.UsersMapper;
import com.bj186.oas.pojo.Users;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    UsersMapper usersMapper;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String selectUser(@RequestBody Users users) {
        System.out.println(666);
        System.out.println("username=" + users.getUsersPhone());
        System.out.println("password=" + users.getUsersPassword());

        Subject currentUser = SecurityUtils.getSubject();     //被shiro管理的对象                                // shiro权限认证主体对象
        if (!currentUser.isAuthenticated()) {  // 是否可以被认证
            UsernamePasswordToken upToken = new UsernamePasswordToken(users.getUsersPhone(), users.getUsersPassword());    // shiro权限认证类型
            upToken.setRememberMe(true);                                                     // 用户登录时效性
            try {
                currentUser.login(upToken);    // 调用realm认证用户权限
                return "success";
            } catch (IncorrectCredentialsException ice) {
                return "密码错误！";
            } catch (LockedAccountException lae) {
                return "账户已被冻结！";
            } catch (UnknownAccountException uae) {
                return "用户名不存在！";
            } catch (AuthenticationException ae) {
                System.out.println(ae.getMessage());
            }
        }
        return null;
    }


    @RequestMapping(value = "/reg")
    public String regUser(@RequestParam String username, @RequestParam String password) {
        System.out.println("reg ------username=" + username);
        System.out.println("reg ------password=" + password);
        Users users = new Users();
        users.setUsersPhone(username);
        users.setUsersPassword(md5(username, password));
        users.setUsersState("0");
        usersMapper.insert(users);
        return "redirect:/statics/html/login.html";
    }

    // 注册时，进行shiro加密，返回加密后的结果，如果在加入shiro之前，存在用户密码不是此方式加密的，那么将无法登录
    // 使用用户名作为盐值
    private String md5(String username, String password){
        String hashAlgorithmName = "MD5";                   // 加密方式
        ByteSource salt = ByteSource.Util.bytes(username);  // 以账号作为盐值
        int hashIterations = 11;                            // 加密11次
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }
}
