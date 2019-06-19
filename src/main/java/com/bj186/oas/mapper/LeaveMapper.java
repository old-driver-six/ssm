package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Leave;

public interface LeaveMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(String leaveId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Leave record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Leave record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Leave selectByPrimaryKey(String leaveId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Leave record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeyWithBLOBs(Leave record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Leave record);
}