package com.bj186.oas.controller.pay;

import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Pay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pay")
@SessionAttributes(value = {"sessionVal"},types = {String.class})
public interface PayController {
    public List<Pay> addPay(@RequestBody Pay pay) throws NullNameException;
}