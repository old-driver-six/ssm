package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Pay;

import java.util.List;

public interface PayMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer payId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Pay record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Pay record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Pay selectByPrimaryKey(Integer paydepid);
    /**
     * 查询薪资表所有信息
     */
    List<Pay> selectAllPay();
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Integer payId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Pay pay);
}