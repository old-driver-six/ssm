package com.bj186.oas.service.personal;

import com.bj186.oas.Util.Massgs;
import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.pojo.Leave;

import java.util.List;

public interface LeaveService {
    /**
     * 添加请假表
     */
    OAResoult<List<Massgs>> insert(Leave leave);

    /**
     *
     * 增加请假意见表,需要传递请假的条的id.
     * @param opinion   请假意见
     * @param state     请假状态值0为同意,1为不同意
     * @Param lid      请假条id
     * @Param sid       操作人id
     * @param leaveTime 请假天数
     * @param uid 请假人id
     * @return  消息回执
     */
    OAResoult<List<Massgs<String>>> updateLeave(String opinion, String state, String lid, Integer leaveTime, Integer sid, Integer uid) throws Exception;

    /**
     * 通过id查询请假条
     * @param lid
     * @return
     */
    OAResoult<Leave> getLeave(String lid);

    /**
     * 查询所有请假条记录
     * @return
     */
    OAResoult<List<Leave>> getLeave();

    /**
     * 查看请假流程
     * @param lid
     * @return
     */
    OAResoult CkeckLeaveProcess(String lid,Integer sid);

}
