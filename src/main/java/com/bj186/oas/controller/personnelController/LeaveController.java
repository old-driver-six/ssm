package com.bj186.oas.controller.personnelController;

import com.bj186.oas.Util.Massgs;
import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.WebSoket.SpringWebSocketHander;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Leave;
import com.bj186.oas.pojo.LeaveAdvice;
import com.bj186.oas.pojo.personalpojo.GetLeaveUtil;
import com.bj186.oas.pojo.personalpojo.Page;
import com.bj186.oas.pojo.personalpojo.ShowLeave;
import com.bj186.oas.pojo.personalpojo.StaffInfo;
import com.bj186.oas.service.personal.LeaveSelService;
import com.bj186.oas.service.personal.LeaveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

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
        OAResoult resoult=new OAResoult();
        try {
            OAResoult<List<Massgs>> insert = service.insert(leave);
            System.out.println(insert);
            SpringWebSocketHander webSocketHander = infoHandler();
            WebSocketSession session = webSocketHander.getUsers().get(insert.getData().get(0).getSid());
            ObjectMapper mapper=new ObjectMapper();
            if(!"".equals(insert)||null!=insert){
                List<Massgs> data = insert.getData();
                for (Massgs massgs : data) {
                    String json = mapper.writeValueAsString(massgs);
                    webSocketHander.handleTextMessage(session,new TextMessage(json));
                }
            }
            return insert;
        }catch (Exception e){
            if(e instanceof IndexOutOfBoundsException ){
                resoult.setCode(-1);
                resoult.setMsg("系统错误!或者你所属部门没有该领导!");
            }
        }
     return resoult;
    }
    @ResponseBody
    @RequestMapping("/saveAdvice.do")
    public OAResoult<List<Massgs<String>>> updateLeaveAdvice(String opinion, String state, String lid, Integer leaveTime, Integer sid, Integer uid){
        System.out.println(lid+"  "+opinion+"  "+sid);
        try {
            OAResoult<List<Massgs<String>>> listOAResoult = service.updateLeave(opinion, state, lid, leaveTime, sid, uid);
            SpringWebSocketHander webSocketHander = infoHandler();
            WebSocketSession session = webSocketHander.getUsers().get(sid);
            ObjectMapper mapper=new ObjectMapper();
            if(!"".equals(listOAResoult)&&null!=listOAResoult) {
                List<Massgs<String>> data = listOAResoult.getData();
                for (Massgs<String> datum : data) {
                    String json = mapper.writeValueAsString(datum);
                    webSocketHander.handleTextMessage(session,new TextMessage(json));
                }
                return listOAResoult;
            }
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

    /**
     * 请假审核是管理者通过id查询请假表里面的信息
     * @param lid
     * @return
     */
    @ResponseBody
    @RequestMapping("/getStfLeave.do")
    public OAResoult<StaffInfo<Leave>> getStfLeave(String lid){
       return leaveSelService.selctStfLeave(lid);
    }

    /**
     * 用查询请假领导审核意见
     * @return
     */
    @RequestMapping("/getLeaveAvice.do")
    @ResponseBody
    public OAResoult<LeaveAdvice> getLeaveAvice(String lid){
        try {
            return leaveSelService.sectAdvice(lid);
        }catch (IndexOutOfBoundsException e){
            OAResoult resoult=new OAResoult();
            resoult.setCode(-1);
            resoult.setMsg("查无数据!");
            return resoult;
        }

    }

    @Bean
    private SpringWebSocketHander infoHandler() {
        return new SpringWebSocketHander();
    }
}
