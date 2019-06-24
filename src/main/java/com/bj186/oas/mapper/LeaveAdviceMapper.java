package com.bj186.oas.mapper;

import com.bj186.oas.pojo.LeaveAdvice;
import com.bj186.oas.pojo.personalpojo.LeaveOpinionUtil;

import java.util.List;

public interface LeaveAdviceMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(String leaveadviceId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(LeaveAdvice record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(LeaveAdvice record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    LeaveAdvice selectByPrimaryKey(String leaveadviceId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(LeaveAdvice record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(LeaveAdvice record);

    /**
     * 通过请假条id查询请假意见id
     * @param lid
     * @return
     */
    List<LeaveOpinionUtil> selByadvicelid(String lid);
}