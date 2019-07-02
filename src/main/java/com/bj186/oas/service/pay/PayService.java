package com.bj186.oas.service.pay;

import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Pay;

import java.util.List;

public interface PayService {
    public String addPay(Pay pay) throws NullNameException;
    public Object selectAllPay(Integer pageNum,Integer pageSize);
    public Pay selectByPrimaryKey(String dep_id);
    public String updateByPrimaryKey(Pay pay);
    public String deleteByPrimaryKey(Integer payId);
    public Object selectStaffPay(String filed, String value, Integer pageSize, Integer pageNum);

}
