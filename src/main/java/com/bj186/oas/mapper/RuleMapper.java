package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Rule;

public interface RuleMapper {
    int deleteByPrimaryKey(Integer ruleId);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectByPrimaryKey(Integer ruleId);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKeyWithBLOBs(Rule record);

    int updateByPrimaryKey(Rule record);
}