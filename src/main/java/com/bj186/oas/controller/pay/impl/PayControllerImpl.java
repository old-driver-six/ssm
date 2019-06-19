package com.bj186.oas.controller.pay.impl;

import com.bj186.oas.controller.pay.PayController;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Pay;
import com.bj186.oas.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pay")//http://localhost:8080/user user找到是注解中标记的类user的Contoller类
@SessionAttributes(value = {"sessionVal"},types = {String.class})
public class PayControllerImpl implements PayController {
    @Autowired
    private PayService payService;
    @RequestMapping("/addPay")//要导入jackson包
    @ResponseBody
    public List<Pay> addPay(@RequestBody Pay pay) throws NullNameException {
        System.out.println(pay);
//       利用异常，改写操作
        if (pay.getPayId().equals("")) {
            throw new NullNameException("薪资id不能为空");
        } else {
            Integer integer = payService.addPay(pay);
            System.out.println(integer);

            List<Pay> pays = new ArrayList<>();
            pays.add(pay);
            return pays;//默认操作一定是转发，因为是在WEB-INF下
        }
    }
}
