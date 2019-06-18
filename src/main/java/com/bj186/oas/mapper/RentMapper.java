package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Rent;

public interface RentMapper {
    int deleteByPrimaryKey(Integer rentId);

    int insert(Rent record);

    int insertSelective(Rent record);

    Rent selectByPrimaryKey(Integer rentId);

    int updateByPrimaryKeySelective(Rent record);

    int updateByPrimaryKey(Rent record);
}