package com.bj186.oas.controller.personnelController;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.Util.UUIDUtil;
import com.bj186.oas.entity.common.CheckingInInsertBean;
import com.bj186.oas.pojo.CheckingIn;
import com.bj186.oas.service.personal.CheckingInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/CheckingIn")
public class CheckingInController {

    @Autowired
    private CheckingInService checkingInService;


    /**
     * 查询所有考勤表
     * @param uId
     * @param pageNow
     * @param pageLimit
     * @return
     */
    @RequestMapping("/selectAllCheckingIn")
    @ResponseBody
    public OAResoult selectAllCheckingIn(
            @RequestParam("uId") Integer uId,
            @RequestParam("page") String pageNow,
            @RequestParam("limit") String pageLimit){

        List<CheckingIn> checkingIns = checkingInService.selectCheckingInByRequirement(uId,null,null,
                null,pageNow,pageLimit);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCount(checkingInService.countAllCheckingIns());
        oaResoult.setCode(0);
        oaResoult.setMsg("");
        oaResoult.setData(checkingIns);
        return oaResoult;
    };

    /**
     * 按需求查询考勤表,条件有时间段,员工个人
     * @param uId
     * @param staffId
     * @param startTime
     * @param endTime
     * @param pageNow
     * @param pageLimit
     * @return
     */
    @RequestMapping("/selectCheckingInByRequirement")
    @ResponseBody
    public OAResoult selectCheckingInByRequirement(
            @RequestParam("uId") Integer uId,
            @RequestParam("staffId") Integer staffId,
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("page") String pageNow,
            @RequestParam("limit") String pageLimit){
        List<CheckingIn> checkingIns = checkingInService.selectCheckingInByRequirement(uId,staffId,startTime,
                endTime,pageNow,pageLimit);
        Integer countCheckingIn = checkingInService.countCheckingIn(uId, staffId, startTime,
                endTime);
        System.out.println(checkingIns.toString());
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCount(countCheckingIn);
        oaResoult.setCode(0);
        oaResoult.setMsg("");
        oaResoult.setData(checkingIns);
        return oaResoult;
    };

    /**
     * 根据主键修改考勤(修改上下班时间和考勤状态)
     * @param checkingInInsertBean
     * @return
     */
    @RequestMapping("/updateCheckingIn")
    @ResponseBody
    public Integer updateCheckingIn(
            @RequestBody CheckingInInsertBean checkingInInsertBean){
        CheckingIn checkingIn =checkingInInsertBean;
        Integer integer = checkingInService.updateChecking(checkingInInsertBean.getuId(),checkingIn);
        return integer;
    }

    /**
     * 主键查询方法
     * @param checkingInInsertBean
     * @return
     */
    @RequestMapping("/selectCheckingInByCheckinginId")
    @ResponseBody
    public CheckingIn selectCheckingInByCheckinginId(
    @RequestBody CheckingInInsertBean checkingInInsertBean){
        CheckingIn checkingIn = checkingInService.selectByPrimaryKey(checkingInInsertBean.getuId(), checkingInInsertBean.getCheckinginId());
        return checkingIn;
    }

    /**
     * 添加单个考勤表
     * @param checkingInInsertBean
     * @return
     */
    @RequestMapping("/insertCheckingIn")
    @ResponseBody
    public Integer insertCheckingIn(
            @RequestBody CheckingInInsertBean checkingInInsertBean
            ){
        CheckingIn checkingIn = new CheckingIn();
        checkingIn.setCheckinginId(UUIDUtil.getUUID());
        checkingIn.setCheckStaffId(checkingInInsertBean.getCheckStaffId());
        checkingIn.setCheckinginStarttime(checkingInInsertBean.getCheckinginStarttime());
        checkingIn.setCheckinginSendtime(checkingInInsertBean.getCheckinginSendtime());
        checkingIn.setCheckinginState(checkingInInsertBean.getCheckinginState());
        System.out.println(checkingIn);
        Integer integer = checkingInService.insertChecking(checkingInInsertBean.getuId(), checkingIn);
        System.out.println(integer);
        return integer;
    }
}
