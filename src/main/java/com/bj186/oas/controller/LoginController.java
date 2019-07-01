package com.bj186.oas.controller;

import com.bj186.oas.Util.MD5;
import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.LoginBean;
import com.bj186.oas.entity.UpdatePwd;
import com.bj186.oas.entity.common.SelectAllBean;
import com.bj186.oas.mapper.UsersMapper;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.pojo.Users;
import com.bj186.oas.service.common.NoticeService;
import com.bj186.oas.service.system.UserService;
import com.bj186.oas.shiro.MyLogoutFilter;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    MyLogoutFilter myLogoutFilter;
    @Autowired
    NoticeService noticeService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public LoginBean selectUser(@RequestBody Users users) {
        LoginBean loginBean = new LoginBean();
        System.out.println(666);
        System.out.println("username=" + users.getUsersPhone());
        System.out.println("password=" + users.getUsersPassword());
        Subject currentUser = SecurityUtils.getSubject();     //被shiro管理的对象                                // shiro权限认证主体对象
        if (!currentUser.isAuthenticated()) {  // 是否可以被认证
            UsernamePasswordToken upToken = new UsernamePasswordToken(users.getUsersPhone(), users.getUsersPassword());    // shiro权限认证类型
            upToken.setRememberMe(true);                                                     // 用户登录时效性
            try {
                currentUser.login(upToken);    // 调用realm认证用户权限
                loginBean.setMsg("success");
                System.out.println(loginBean);
                Staff staff = noticeService.selectByPhoneKey(users.getUsersPhone());
                System.out.println(staff);
                loginBean.setDepName(staff.getDepartment().getDepName());
                loginBean.setStaffName(staff.getStaffName());
                loginBean.setuId(staff.getStaffId());
            } catch (IncorrectCredentialsException ice) {
                loginBean.setMsg("密码错误！");
            } catch (LockedAccountException lae) {
                loginBean.setMsg("账户已被冻结！");
            } catch (UnknownAccountException uae) {
                loginBean.setMsg("用户名不存在！");
            } catch (AuthenticationException ae) {
                System.out.println(ae.getMessage());
            }
        }else {
            loginBean.setMsg("重复登录或登录出错！");
        }
        System.out.println(loginBean);
        return loginBean;
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public Boolean logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(666);
        try {
            return myLogoutFilter.preHandle(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @RequestMapping(value = "/updatePwd")
    @ResponseBody
    public OAResoult updatePwd(@RequestBody UpdatePwd updatePwd) {
        Integer integer = userService.updatePwd(updatePwd);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(integer);
        return oaResoult;
    }

    @RequestMapping(value = "/lo")
    @ResponseBody
    public void lo(@RequestBody SelectAllBean selectAllBean) {
        System.out.println(selectAllBean.getuId());

    }

    @RequestMapping(value = "/reg")
    public String regUser(@RequestParam String username, @RequestParam String password) {
        System.out.println("reg ------username=" + username);
        System.out.println("reg ------password=" + password);
        Users users = new Users();
        users.setUsersPhone(username);
        users.setUsersPassword(MD5.getMd5(username, password));
        users.setUsersState("0");
        usersMapper.insert(users);
        return "redirect:/statics/html/login.html";
    }

    // 注册时，进行shiro加密，返回加密后的结果，如果在加入shiro之前，存在用户密码不是此方式加密的，那么将无法登录
    // 使用用户名作为盐值

}
