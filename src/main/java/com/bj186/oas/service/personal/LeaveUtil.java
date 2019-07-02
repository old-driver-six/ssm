package com.bj186.oas.service.personal;

import com.bj186.oas.Util.UUIDUtil;
import com.bj186.oas.mapper.LeaveAdviceMapper;
import com.bj186.oas.pojo.LeaveAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("leaveUtil")
public class LeaveUtil {
    @Autowired
    private LeaveAdviceMapper mapper;

    /**
     * 修改请假意见表里面的意见
     * @param lid
     * @param opinion
     * @param state
     * @param post
     * @param livid
     * @return
     */
    public String insertAdvice(String lid,String opinion,String state,String post,String livid ) throws Exception {
        System.out.println("职位:"+post);
        LeaveAdvice advice=new LeaveAdvice();
        Integer integer=-1;
        advice.setLeaveadviceId(livid);
        if("主管".equals(post)){
            advice.setAdvicegroup(opinion);
            advice.setAdvicegroupstate(state);
        }
        if("经理".equals(post)){
            advice.setAdvicepart(opinion);
            advice.setAdvicepartstate(state);
        }
        if("员工".equals(post)){
            advice.setAdvicesum(opinion);
            advice.setAdvicesumstate(state);
        }
        if("".equals(livid)||null==livid){
            advice.setAdvicelid(UUIDUtil.getUUID());
            advice.setAdvicelid(lid);
            integer=mapper.insert(advice);
        }else {
            integer=mapper.updateByPrimaryKeySelective(advice);
        }
        if (integer==0){
            throw new Exception();
        }
        return advice.getLeaveadviceId();
    }
}
