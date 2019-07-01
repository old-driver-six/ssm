package com.bj186.oas.service.common.impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.mapper.*;
import com.bj186.oas.pojo.*;
import com.bj186.oas.service.common.InstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("instService")
public class InstServiceImpl implements InstService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public List<Rule> selectRuleAll(Map map) {
        if (map.get("field") == null || map.get("value") == null || map.get("field").equals("") || map.get("value").equals("")){
            return ruleMapper.selectAll();
        }else {
            return ruleMapper.selectAllVague(map);
        }

    }

    @Override
    public OAResoult selectRuleByCreatorId(Integer uId, Integer page, Integer limit,String field,String value) {
        Map<String, Serializable> map = new HashMap<>();
        map.put("uId",uId);
        map.put("field",field);
        map.put("value","\'%"+value+"%\'");
        Integer count = ruleMapper.selectRuleByCreatorId(map).size();
        map.put("page",(page - 1)*limit);
        map.put("limit",limit);
        List<Rule> rules = ruleMapper.selectRuleByCreatorId(map);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(0);
        oaResoult.setCount(count);
        oaResoult.setData(rules);
        return oaResoult;
    }

    @Override
    public Rule selectRule(Integer ruleId) {
        return ruleMapper.selectByPrimaryKey(ruleId);
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
