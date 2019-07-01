package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Position;

import java.util.List;

public interface PositionMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer positionId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Position record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Position record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Position selectByPrimaryKey(Integer positionId);

    List<Position> selectPosition();

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Position record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Position record);
}