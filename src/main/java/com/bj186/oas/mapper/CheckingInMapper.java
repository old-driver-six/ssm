package com.bj186.oas.mapper;

import com.bj186.oas.pojo.CheckingIn;

public interface CheckingInMapper {
    int deleteByPrimaryKey(String checkinginId);

    int insert(CheckingIn record);

    int insertSelective(CheckingIn record);

    CheckingIn selectByPrimaryKey(String checkinginId);

    int updateByPrimaryKeySelective(CheckingIn record);

    int updateByPrimaryKey(CheckingIn record);
}