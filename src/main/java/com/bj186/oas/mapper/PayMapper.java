package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Pay;

public interface PayMapper {
    int deleteByPrimaryKey(Integer payId);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer payId);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);
}