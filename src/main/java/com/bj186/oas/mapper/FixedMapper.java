package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Fixed;

public interface FixedMapper {
    int deleteByPrimaryKey(Integer fixId);

    int insert(Fixed record);

    int insertSelective(Fixed record);

    Fixed selectByPrimaryKey(Integer fixId);

    int updateByPrimaryKeySelective(Fixed record);

    int updateByPrimaryKey(Fixed record);
}