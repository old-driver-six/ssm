package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Position;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer positionId);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer positionId);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}