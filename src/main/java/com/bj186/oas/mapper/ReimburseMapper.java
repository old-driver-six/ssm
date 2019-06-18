package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Reimburse;

public interface ReimburseMapper {
    int deleteByPrimaryKey(Integer reimId);

    int insert(Reimburse record);

    int insertSelective(Reimburse record);

    Reimburse selectByPrimaryKey(Integer reimId);

    int updateByPrimaryKeySelective(Reimburse record);

    int updateByPrimaryKey(Reimburse record);
}