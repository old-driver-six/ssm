package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.mapper.LeaveMapper;
import com.bj186.oas.pojo.personalpojo.GetLeaveUtil;
import com.bj186.oas.pojo.personalpojo.Page;
import com.bj186.oas.pojo.personalpojo.Paging;
import com.bj186.oas.pojo.personalpojo.ShowLeave;
import com.bj186.oas.service.personal.LeaveSelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询请假消息
 */
@Service("leaveSelService")
public class LeaveSelServiceImpl implements LeaveSelService {
    @Autowired
    private LeaveMapper mapper;     //请假表映射关系
    @Override
    public OAResoult<List<ShowLeave>> selctLeave(Integer sid,Integer pageSize,Integer pageThis) {
        Page page=new Page();
        page.setSid(sid);
        page.setPageSize(pageSize);
        page.setPageThis((pageThis-1)*pageSize);
        Paging<ShowLeave> showLeavePaging = mapper.showLeaveLimit(page);
        OAResoult<List<ShowLeave>> resoult=new OAResoult<>();
        resoult.setCode(0);
        resoult.setData(showLeavePaging.getData());
        resoult.setCount(showLeavePaging.getCot());
        return resoult;
    }

    @Override
    public OAResoult<List<ShowLeave>> selctLeave(Integer sid, Integer pageSize, Integer pageThis, GetLeaveUtil getLeaveUtil) {
        Page<GetLeaveUtil> page=new Page<>();
        page.setSid(sid);
        page.setPageSize(pageSize);
        page.setPageThis((pageThis-1)*pageSize);
        page.setEntity(getLeaveUtil);
        Paging<ShowLeave> showLeavePaging = mapper.showLeaveLimit(page);
        OAResoult<List<ShowLeave>> resoult=new OAResoult<>();
        try {
            resoult.setCode(0);
            resoult.setData(showLeavePaging.getData());
            resoult.setCount(showLeavePaging.getCot());
        }catch (NullPointerException e){
            e.printStackTrace();
            resoult.setMsg("没有符合的数据!");
            resoult.setCode(-1);
        }
        return resoult;
    }
}
