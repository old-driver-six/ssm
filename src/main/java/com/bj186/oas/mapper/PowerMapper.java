package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Power;

public interface PowerMapper {
    int deleteByPrimaryKey(Integer powerId);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(Integer powerId);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);
}