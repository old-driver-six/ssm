package com.bj186.oas.service.pay.impl;

import com.bj186.oas.mapper.PayMapper;
import com.bj186.oas.pojo.Pay;
import com.bj186.oas.service.pay.PayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("payServiceImpl")
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper = null;
    @Transactional
    public Integer addPay(Pay pay){
        int insert = payMapper.insert(pay);
        return insert;
    }
}