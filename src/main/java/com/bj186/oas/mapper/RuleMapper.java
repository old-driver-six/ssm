package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Rule;

public interface RuleMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer ruleId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Rule record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Rule record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Rule selectByPrimaryKey(Integer ruleId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Rule record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeyWithBLOBs(Rule record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Rule record);
}