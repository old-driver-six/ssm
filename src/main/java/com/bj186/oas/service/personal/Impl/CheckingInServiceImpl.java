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
     * 根据员工ID查询员工考勤表
     * @param staffId
     * @return
     */
    @Override
    public List<CheckingIn> selectCheckingInByRequirement(Integer uId,Integer staffId,String startTime,String endTime,String pageNow, String pageLimit ) {
        Staff staff = staffMapper.selectByPrimaryKey(staffId);
        Integer depId = staff.getDepartment().getDepId();
        if (depId == 1){
        Map<String,Object> map = new LinkedHashMap<>();
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

    @Override
    public Integer insertChecking(Integer uid, CheckingIn checkingIn) {
        return null;
    }


}
