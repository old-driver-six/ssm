package com.bj186.oas.controller.personnelController;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.WorkLog;
import com.bj186.oas.pojo.personalpojo.Paging;
import com.bj186.oas.pojo.personalpojo.WorkLogUtil;
import com.bj186.oas.service.personal.WorkLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/workLog")
public class WorkLogController {
    @Resource
    private WorkLogService workLogService;

    /**
     * 添加日志
     * @param worklogName
     * @param worklogCreateid
     * @param worklogContent
     * @return
     */
    @ResponseBody
    @RequestMapping("/save.do")
    public OAResoult saveWorkLog(String worklogName,Integer worklogCreateid,String worklogContent){
        System.out.println(worklogContent);
        try {
         return workLogService.insertWorkLog(worklogName,worklogCreateid,worklogContent);
        } catch (NullNameException e) {
            e.printStackTrace();
            OAResoult resoult=new OAResoult();
            resoult.setCode(0);
            resoult.setMsg(e.getMessage());
        }
        return null;
    }

    /**
     * 修改日志
     * @param workLog
     * @return
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public OAResoult uodateWorkLog(WorkLog workLog){
        OAResoult resoult=new OAResoult();
        resoult.setCode(0);
        if ("".equals(workLog)||null==workLog){
            resoult.setMsg("请指定要修改的内容");
            return resoult;
        }
        try {
           return workLogService.updateWorkLog(workLog);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof NullNameException){
                resoult.setMsg(e.getMessage());
                return resoult;
            }
        }
        resoult.setMsg("请指定要修改的id");
        return resoult;
    }
    @ResponseBody
    @RequestMapping("/delete.do")
    public OAResoult deleteWorkLog(Integer workId){
        OAResoult resoult=new OAResoult();
        resoult.setCode(0);
        if(null==workId){
            resoult.setMsg("请指定要删除的账号!");
            return resoult;
        }
        try {
           return workLogService.deleteWorkLog(workId);
        } catch (NullNameException e) {
            e.printStackTrace();
            resoult.setMsg(e.getMessage());
            return resoult;
        }
    }

    @RequestMapping("/selLimit.do")
    @ResponseBody
    public OAResoult<Paging<WorkLog>> selLimit(WorkLogUtil workLogUtil){
       return workLogService.selWorkLog(10007,1,1);
    }
}
