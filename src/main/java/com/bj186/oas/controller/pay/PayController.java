package com.bj186.oas.controller.pay;

import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Pay;

import java.util.List;

public interface PayController {
    public String addPay(Pay pay) throws NullNameException;
    public String selectAllPay();
    public Pay selectByPrimaryKey(Integer payId);
    public Integer updateByPrimaryKey(Integer payId);
    public Integer deleteByPrimaryKey(Integer payId);

}