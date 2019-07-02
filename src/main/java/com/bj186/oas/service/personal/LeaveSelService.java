package com.bj186.oas.service.personal;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.pojo.Leave;
import com.bj186.oas.pojo.LeaveAdvice;
import com.bj186.oas.pojo.personalpojo.GetLeaveUtil;
import com.bj186.oas.pojo.personalpojo.Page;
import com.bj186.oas.pojo.personalpojo.ShowLeave;
import com.bj186.oas.pojo.personalpojo.StaffInfo;

import java.util.List;

public interface LeaveSelService {
    /**
     * 展示一部分请假的简略信息
     */
    OAResoult<List<ShowLeave>> selctLeave(Integer sid,Integer pageSize,Integer pageThis);
    OAResoult<List<ShowLeave>> selctLeave(Integer sid,Integer pageSize,Integer pageThis,GetLeaveUtil getLeaveUtil);

    /**
     * 通过请假表的id,或者请假详情表的id查询请假信息
     * @param lid
     * @return
     */
    OAResoult<StaffInfo<Leave>> selctStfLeave(String lid);

    /**
     * 通过请假条id或者请假意见id,查询请假信息
     * @param lid
     * @return
     */
    OAResoult<LeaveAdvice> sectAdvice(String lid);
}
