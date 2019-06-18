package com.bj186.oas.mapper;

import com.bj186.oas.pojo.StaffPower;

public interface StaffPowerMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer spId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(StaffPower record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(StaffPower record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    StaffPower selectByPrimaryKey(Integer spId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(StaffPower record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(StaffPower record);
}