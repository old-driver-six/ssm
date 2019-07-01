package com.bj186.oas.controller.personnelController;

import com.bj186.oas.Util.Massgs;
import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Leave;
import com.bj186.oas.pojo.personalpojo.GetLeaveUtil;
import com.bj186.oas.pojo.personalpojo.Page;
import com.bj186.oas.pojo.personalpojo.ShowLeave;
import com.bj186.oas.service.personal.LeaveSelService;
import com.bj186.oas.service.personal.LeaveService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 请假操作接口:
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService service;
    @Resource
    private LeaveSelService leaveSelService;

    /**
     * 添加请假条
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveLeave.do")
    public OAResoult<List<Massgs>> add(@RequestBody() Leave leave){
        leave.setLeaveStaffId(10007);
        System.out.println(leave);
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
    public OAResoult<Leave> getLeave(String leaveId){
        System.out.println(leaveId);
        return service.getLeave(leaveId);
    }

    @ResponseBody
    @RequestMapping("/showLeave.do")
    public OAResoult<List<ShowLeave>> selLeave(Integer sid,Integer pageSize,Integer pageThis){
        return leaveSelService.selctLeave(sid,pageSize,pageThis);
    }
    @ResponseBody
    @RequestMapping("/selLeaveJuit.do")
    public OAResoult<List<ShowLeave>> selLeaveJuit(Integer sid,Integer pageSize,Integer pageThis,HttpServletRequest request){
        String getLeave = request.getParameter("getLeave");
        ObjectMapper mapper=new ObjectMapper();
        GetLeaveUtil getLeaveUtil=null;
        try {
            getLeaveUtil = mapper.readValue(getLeave, GetLeaveUtil.class);
        } catch (IOException e) {
            e.printStackTrace();
            OAResoult resoult=new OAResoult();
            resoult.setCode(-1);
            resoult.setMsg("请检查输入条件格式是否正确！");
            return resoult;
        }
        System.out.println(getLeaveUtil);
       return leaveSelService.selctLeave(sid,pageSize,pageThis,getLeaveUtil);
    }
    @ResponseBody
    @RequestMapping("/update.do")
    public OAResoult updateLeave(@RequestBody Leave leave){
        System.out.println(leave);
        OAResoult resoult=new OAResoult();
        resoult.setCode(-1);
        try {
          return service.update(leave);
        } catch (NullNameException e) {
            e.printStackTrace();
            resoult.setMsg(e.getMessage());
        }
        return resoult;
    }
}
