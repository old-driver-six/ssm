package com.bj186.oas.service.personal;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.pojo.personalpojo.GetLeaveUtil;
import com.bj186.oas.pojo.personalpojo.Page;
import com.bj186.oas.pojo.personalpojo.ShowLeave;

import java.util.List;

public interface LeaveSelService {
    /**
     * 展示一部分请假的简略信息
     */
    OAResoult<List<ShowLeave>> selctLeave(Integer sid,Integer pageSize,Integer pageThis);
    OAResoult<List<ShowLeave>> selctLeave(Integer sid,Integer pageSize,Integer pageThis,GetLeaveUtil getLeaveUtil);
}
