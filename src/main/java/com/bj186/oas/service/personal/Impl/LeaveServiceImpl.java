package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.mapper.LeaveMapper;
import com.bj186.oas.pojo.Leave;
import com.bj186.oas.service.personal.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
    @Resource
    private LeaveMapper leavemapper;
    @Override
    public Boolean insert(Leave leave) {
        int insert = leavemapper.insert(leave);
        return insert>0;
    }

    @Override
    public Boolean updateLeave(String opinion, String state, String lid) {
        //
        return null;
    }
}
