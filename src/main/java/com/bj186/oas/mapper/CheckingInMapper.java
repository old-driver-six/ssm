package com.bj186.oas.mapper;

import com.bj186.oas.pojo.CheckingIn;

import java.util.List;
import java.util.Map;

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
    List<CheckingIn> selectByRequirement(Map map);

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

    int countCheckingIn(Map map);

    int countAllCheckingIn();

    CheckingIn selectByPrimaryKey(String checkinginId);
}