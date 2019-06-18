package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Fixed;

public interface FixedMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer fixId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Fixed record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Fixed record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Fixed selectByPrimaryKey(Integer fixId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Fixed record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Fixed record);
}