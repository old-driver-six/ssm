package com.bj186.oas.service.pay;

import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Pay;

import java.util.List;

public interface PayService {
    public String addPay(Pay pay) throws NullNameException;
    public List<Pay> selectAllPay();
    public Pay selectByPrimaryKey(Integer paydepid);
    public String updateByPrimaryKey(Pay pay);
//    public Integer updateByPrimaryKeySelective(Integer payId);
    public String deleteByPrimaryKey(Integer payId);
//    public Integer insertSelective(Pay pay);
}
