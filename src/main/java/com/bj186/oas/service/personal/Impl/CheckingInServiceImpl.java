package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.mapper.CheckingInMapper;
import com.bj186.oas.mapper.StaffMapper;
import com.bj186.oas.pojo.CheckingIn;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.personal.CheckingInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("CheckingInService")
public class CheckingInServiceImpl implements CheckingInService {

    @Autowired
    private CheckingInMapper checkingInMapper;
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 根据员工ID或者日期查询员工考勤表
     * @param staffId
     * @return
     */
    @Override
    public List<CheckingIn> selectCheckingInByRequirement(
            Integer uId,Integer staffId,String startTime,
            String endTime,String oneTime,String pageNow,
            String pageLimit ) {
        Staff staff = staffMapper.selectByPrimaryKey(staffId);
        Integer depId = staff.getDepartment().getDepId();
        if (depId == 1){
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("oneTime","\'%"+oneTime+"%\'");
        map.put("startTime","\'"+startTime+"\'");
        map.put("endTime","\'"+endTime+"\'");
        map.put("checkstaffId",staffId);
        map.put("LimitParameter_1",(Integer.parseInt(pageNow)-1)*Integer.parseInt(pageLimit));
        map.put("LimitParameter_2",Integer.parseInt(pageLimit));
        List<CheckingIn> checkingIns = checkingInMapper.selectByRequirement(map);
        return checkingIns;
        }else{
            return null;
        }
    }


    /**
     * 考勤记录表总数
     * @return
     */
    public Integer countAllCheckingIns(){
        int i = checkingInMapper.countAllCheckingIn();
        return i;
    }

    /**
     * 按需求计数
     * @param uId
     * @param staffId
     * @param startTime
     * @param endTime
     * @param oneTime
     * @param pageNow
     * @param pageLimit
     * @return
     */
    @Override
    public Integer countCheckingIn(
            Integer uId,Integer staffId,String startTime,
            String endTime,String oneTime,String pageNow,
            String pageLimit) {
        Staff staff = staffMapper.selectByPrimaryKey(staffId);
        Integer depId = staff.getDepartment().getDepId();
        if (depId == 1){
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("oneTime","\'%"+oneTime+"%\'");
            map.put("startTime","\'"+startTime+"\'");
            map.put("endTime","\'"+endTime+"\'");
            map.put("checkstaffId",staffId);
            map.put("LimitParameter_1",(Integer.parseInt(pageNow)-1)*Integer.parseInt(pageLimit));
            map.put("LimitParameter_2",Integer.parseInt(pageLimit));
            int i = checkingInMapper.countCheckingIn(map);
            return i;
        }else{
            return null;
        }
    }

    /**
     * 修改考勤表
     * @param uId
     * @param checkingIn
     * @return
     */
    @Override
    public Integer updateChecking(Integer uId,CheckingIn checkingIn) {
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        Integer depId = staff.getDepartment().getDepId();
        if (depId == 1){
            int i = checkingInMapper.updateByPrimaryKeySelective(checkingIn);
            return  i;
        }
        return null;
    }

    /**
     *添加考勤表
     * @param uId
     * @param checkingIn
     * @return
     */
    @Override
    public Integer insertChecking(Integer uId, CheckingIn checkingIn) {
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        Integer depId = staff.getDepartment().getDepId();
        if (depId == 1){
            int insert = checkingInMapper.insert(checkingIn);
            return insert;
        }
        return null;
    }

    /**
     * 主键查询,修改的时候后端调取数据可用
     * @param uId
     * @param checkinginId
     * @return
     */
    public CheckingIn selectByPrimaryKey(Integer uId,String checkinginId){
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        Integer depId = staff.getDepartment().getDepId();
        if (depId == 1){
            CheckingIn checkingIn = checkingInMapper.selectByPrimaryKey(checkinginId);
            return checkingIn;
        }
            return null;
    }
}
