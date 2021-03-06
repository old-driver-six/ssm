package com.bj186.oas.service.common;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.pojo.Rule;
import java.util.List;
import java.util.Map;

public interface InstService {
    /**
     * 查询所有可见制度
     * @return
     */
    List<Rule> selectRuleAll(Map map);
    /**
     * 通过员工ID查询 此员工发布的制度（我的制度）
     * @param uId
     * @return
     */
    OAResoult selectRuleByCreatorId(Integer uId, Integer page, Integer limit, String field, String value);
    /**
     * 查询制度详细信息
     * @return
     */
    Rule selectRule(Integer ruleId);
    /**
     * 发布制度（包含权限判定）
     * @param rule
     * @return
     */
    Integer insertRule(Integer uId, Rule rule);

    /**
     * 修改制度
     * @param rule
     * @return
     */
    int updateByPrimaryKey(Rule rule);
}
