package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Leave;

public interface LeaveMapper {
    /**
     *
     * @mbggenerated 2019-06-19
     */
    int deleteByPrimaryKey(String leaveId);

    /**
     *
     * @mbggenerated 2019-06-19
     */
    int insert(Leave record);

    /**
     *
     * @mbggenerated 2019-06-19
     */
    int insertSelective(Leave record);

    /**
     *
     * @mbggenerated 2019-06-19
     */
    Leave selectByPrimaryKey(String leaveId);

    /**
     *
     * @mbggenerated 2019-06-19
     */
    int updateByPrimaryKeySelective(Leave record);

    /**
     *
     * @mbggenerated 2019-06-19
     */
    int updateByPrimaryKeyWithBLOBs(Leave record);

    /**
     *
     * @mbggenerated 2019-06-19
     */
    int updateByPrimaryKey(Leave record);
}