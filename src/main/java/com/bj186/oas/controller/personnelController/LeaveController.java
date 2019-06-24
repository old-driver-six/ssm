package com.bj186.oas.controller.personnelController;

import com.bj186.oas.Util.Massgs;
import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.Util.UUIDUtil;
import com.bj186.oas.pojo.Leave;
import com.bj186.oas.service.personal.LeaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 请假操作接口:
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Resource
    private LeaveService service;

    /**
     * 添加请假条
     * @param leave
     * @return
     */
    @RequestMapping("/saveLeave.do")
    @ResponseBody
    public OAResoult<List<Massgs>> add(Leave leave){
        leave=new Leave();
        leave.setLeaveId(UUIDUtil.getUUID());                   //后端赋值
        leave.setLeaveStaffId(10006);
        leave.setLeaveProcessing("正常");
        leave.setLeaveTitle("生病了");
        leave.setLeaveType("1");
        leave.setLeaveTime(4);
        leave.setLeaveState("1");
        leave.setLeaveReason("生病了,难受!");
        leave.setLeaveCeatetime(System.currentTimeMillis());    //后端赋值
        return  service.insert(leave);
    }
    @ResponseBody
    @RequestMapping("/saveAdvice.do")
    public OAResoult<List<Massgs<String>>> updateLeaveAdvice(String opinion, String state, String lid, Integer leaveTime, Integer sid, Integer uid){
        opinion="测试成功";
        state="0";
        lid="cf7c3da083af4f1ab3a414f565955afa";
        leaveTime=4;
        sid=10001;
        uid=10006;
        try {
            OAResoult<List<Massgs<String>>> listOAResoult = service.updateLeave(opinion, state, lid, leaveTime, sid, uid);
            return  listOAResoult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/getLeave.do")
    public OAResoult<List<Leave>> getLeave(){
        return service.getLeave();
    }

}
