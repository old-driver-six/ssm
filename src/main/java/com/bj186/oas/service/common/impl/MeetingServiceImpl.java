package com.bj186.oas.service.common.impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.common.SelectAllBean;
import com.bj186.oas.mapper.*;
import com.bj186.oas.pojo.*;
import com.bj186.oas.service.common.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("meetingService")
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private MeetingStaffMapper meetingStaffMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private MeetingMapper meetMapper;
    @Override
    public List<Meeting> selectMeetByKey(SelectAllBean selectAllBean) {
        List<Meeting> meetings;
        //通过uId查询部门
        Staff staff = staffMapper.selectByPrimaryKey(selectAllBean.getuId());
        Department department = staff.getDepartment();
        Map<String,Serializable> map = new HashMap<>();
        map.put("depId",department.getDepId());
        if (!department.getDepName().equals("董事局")) {
            //通过部门进一步查询公告列表
            if (!staff.getPosition().getPositionName().equals("经理"))
                map.put("type","部门会议");
        }
        if (selectAllBean.getValue() == null || selectAllBean.getField().equals("")){
            meetings = meetMapper.selectMeetByDepId(map);
        }else {
            map.put("field",selectAllBean.getField());
            map.put("value","\'%"+selectAllBean.getValue()+"%\'");
            meetings = meetMapper.selectMeetByDepIdVague(map);
        }
        return meetings;
    }

    @Override
    public OAResoult selectMyAll(Integer uId, Integer page, Integer limit,String field,String value) {
        Map<String, Serializable> map = new HashMap<>();
        map.put("uId",uId);
        map.put("field",field);
        map.put("value","\'%"+value+"%\'");
        Integer count = meetMapper.selectMeetAllVague(map).size();
        map.put("page",(page - 1)*limit);
        map.put("limit",limit);
        List<Meeting> meetings = meetMapper.selectMeetAllVague(map);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(0);
        oaResoult.setCount(count);
        oaResoult.setData(meetings);
        return oaResoult;
    }

    @Override
    public OAResoult update(Meeting meeting) {
        meeting.setMeetingState(1);
        int i = meetMapper.updateByPrimaryKeySelective(meeting);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(i);
        return oaResoult;
    }

    @Override
    public Integer insert(Meeting meeting, List<String> depNames) {
        if (meeting.getMeetingType().equals("部门会议")){
            if(depNames.size() != 1)
                return  -1;
        }
        meeting.setMeetingState(0);
        int insert = meetMapper.insert(meeting);
        for (String depName : depNames) {
            //通过部门名称获取id
            Department department = departmentMapper.selectByName(depName);
            MeetingStaff meetingStaff = new MeetingStaff();
            //set公告部门表数据
            meetingStaff.setMeetingstaffEmpid(department.getDepId());
            meetingStaff.setMeetingstaffMeetingId(meeting.getMeetingId());
            //添加操作
            meetingStaffMapper.insert(meetingStaff);
        }
        return insert;
    }
}
