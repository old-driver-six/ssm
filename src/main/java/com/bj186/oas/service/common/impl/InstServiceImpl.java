package com.bj186.oas.service.common.impl;

import com.bj186.oas.mapper.*;
import com.bj186.oas.pojo.*;
import com.bj186.oas.service.common.InstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("instService")
public class InstServiceImpl implements InstService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public List<Rule> selectRuleAll() {
        return ruleMapper.selectAll();
    }

    @Override
    public List<Rule> selectRuleByCreatorId(Integer uId) {
        return ruleMapper.selectRuleByCreatorId(uId);
    }

    @Override
    public Integer insertRule(Integer uId, Rule rule) {
        //获取用户特征
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        //董事局才能制定公司制度
        if(!staff.getDepartment().getDepName().equals("董事局")){
            return -1;
        }
        int insert = ruleMapper.insert(rule);
        return insert;
    }

    @Override
    public int updateByPrimaryKey(Rule rule) {
        int i = ruleMapper.updateByPrimaryKeyWithBLOBs(rule);
        return i;
    }
}
