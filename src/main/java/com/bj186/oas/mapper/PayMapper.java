package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Pay;

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
    Pay selectByPrimaryKey(Integer payId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Pay record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Pay record);
}