package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.mapper.LeaveAdviceMapper;
import com.bj186.oas.mapper.LeaveMapper;
import com.bj186.oas.pojo.Leave;
import com.bj186.oas.pojo.LeaveAdvice;
import com.bj186.oas.pojo.personalpojo.*;
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
    @Autowired
    private LeaveAdviceMapper adviceMapper;     //请假表映射关系
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

    /**
     * 通过请假表的id,或者请假详情表的id查询请假信息
     * @param lid
     * @return
     */
    @Override
    public OAResoult<StaffInfo<Leave>> selctStfLeave(String lid) {
        OAResoult<StaffInfo<Leave>> resoult=new OAResoult<>();
        //判断是否传递过来的id是否为空
        if("".equals(lid)){
            resoult.setCode(-1);
            resoult.setMsg("系统故障,请稍后重试!");
            return resoult;
        }
        StaffInfo<Leave> leaveAdive = mapper.getLeaveAdive(lid);        //如果这里查询出来的值为空,则可能是请假详情的id
        if("".equals(leaveAdive)&&null==leaveAdive){
            leaveAdive=mapper.getLeaveAdiveId(lid);
        }
        if("".equals(leaveAdive)&&null==leaveAdive){        //如果查询还为空的话,说明数据库中没有这条数据了
            resoult.setCode(-1);
            resoult.setMsg("用户撤回了请假审核!");
            return resoult;
        }
        System.out.println(leaveAdive);
        resoult.setData(leaveAdive);
        resoult.setCode(0);
        return resoult;
    }

    /**
     *  通过请假条id或者请假意见id,查询请假信息
     * @param lid
     * @return
     */
    @Override
    public OAResoult<LeaveAdvice> sectAdvice(String lid) {
        OAResoult<LeaveAdvice> resoult=new OAResoult();
        if("".equals(lid)&&lid==null){
            resoult.setCode(-1);
            resoult.setMsg("数据异常!");
            return resoult;
        }
        LeaveAdvice advice = adviceMapper.selectByPrimaryKey(lid);
        if(advice!=null){
            resoult.setCode(0);
            resoult.setData(advice);
            return resoult;
        }else {
            List<LeaveAdvice> leaveAdvices = adviceMapper.selByLeaveId(lid);
            System.out.println(leaveAdvices);
            if (null!=leaveAdvices && !leaveAdvices.isEmpty());
            {
                resoult.setCode(0);
                resoult.setData(leaveAdvices.get(0));
                return resoult;
            }

        }

    }
}
