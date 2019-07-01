package com.bj186.oas.mapper;

import com.bj186.oas.pojo.WorkLog;
import com.bj186.oas.pojo.personalpojo.WorkLogUtil;

import java.util.List;

public interface WorkLogMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer worklogId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(WorkLog record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(WorkLog record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    WorkLog selectByPrimaryKey(Integer worklogId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(WorkLog record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeyWithBLOBs(WorkLog record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(WorkLog record);

    List<WorkLog> selectWorkBymapper(WorkLogUtil workLogUtil);
}