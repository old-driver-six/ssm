package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Power;

public interface PowerMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer powerId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Power record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Power record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Power selectByPrimaryKey(Integer powerId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Power record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Power record);
}