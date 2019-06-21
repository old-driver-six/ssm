package com.bj186.oas.service.pay;

import com.bj186.oas.pojo.Pay;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface PayService {
    public Integer addPay(Pay pay);
    public Pay selectAllPay();
    public Pay selectByPrimaryKey(Integer payId);
    public Integer updateByPrimaryKey(Integer payId);
//    public Integer updateByPrimaryKeySelective(Integer payId);
    public Integer deleteByPrimaryKey(Integer payId);
//    public Integer insertSelective(Pay pay);
}
