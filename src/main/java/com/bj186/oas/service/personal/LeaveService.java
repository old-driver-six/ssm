package com.bj186.oas.service.personal;

import com.bj186.oas.pojo.Leave;

public interface LeaveService {
    /**
     * 添加请假表
     */
    Boolean insert(Leave leave) throws Exception;

    /**
     * 增加请假意见表,需要传递请假的条的id.
     * @param opinion   请假意见
     * @param state     请假状态值0为同意,1为不同意
     * @Param lid       请假条id
     * @return
     */
    Boolean updateLeave(String opinion,String state,String lid);
}
