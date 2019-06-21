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

    /**
     * 薪资录入
     * @param pay 薪资表
     * @return
     */
    @Transactional
    public Integer addPay(Pay pay){
        int insert=0;
        try {
            insert = payMapper.insert(pay);

        }catch (Exception e){
            e.printStackTrace();
        }
        return insert;
    }

    /**
     * 查询薪资表所有信息
     * @return
     */
    @Transactional
    public Pay selectAllPay(){
        return payMapper.selectAllPay();
    }

    /**
     * 通过薪资id查询
     * @param payId
     * @return
     */
    @Transactional
    public Pay selectByPrimaryKey(Integer payId) {
        return payMapper.selectByPrimaryKey(payId);

    }

    /**
     * 通过薪资Id更新
     * @param payId
     * @return
     */
    @Transactional
    public Integer updateByPrimaryKey(Integer payId) {
        return  payMapper.updateByPrimaryKey(payId);
    }

//    /**
//     * 通过薪资Id更新查询数据
//     * @param payId
//     * @return
//     */
//    @Transactional
//    public Integer updateByPrimaryKeySelective(Integer payId) {
//        return payMapper.updateByPrimaryKeySelective(payId);
//
//    }

    /**
     * 通过Id删除薪资
     * @param payId
     * @return
     */
    @Transactional
    public Integer deleteByPrimaryKey(Integer payId) {
        return payMapper.deleteByPrimaryKey(payId);
    }
//
//    @Override
//    public Integer insertSelective(Pay pay) {
//        return payMapper.insertSelective(pay);
//
//    }


}