package com.bj186.oas.mapper;

import com.bj186.oas.pojo.CheckingIn;

public interface CheckingInMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(String checkinginId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(CheckingIn record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(CheckingIn record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    CheckingIn selectByPrimaryKey(String checkinginId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(CheckingIn record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(CheckingIn record);
}