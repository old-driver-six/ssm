package com.bj186.oas.service.common.impl;

import com.bj186.oas.mapper.AnnouncementsExtentMapper;
import com.bj186.oas.mapper.AnnouncementsMapper;
import com.bj186.oas.mapper.DepartmentMapper;
import com.bj186.oas.mapper.StaffMapper;
import com.bj186.oas.pojo.*;
import com.bj186.oas.service.common.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private AnnouncementsExtentMapper annExtentMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private AnnouncementsMapper annMapper;
    @Override
    public List<Announcements> selectAnnsByKey(Integer uId) {
        //通过uId查询部门
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        //通过部门进一步查询公告列表
        Department department = departmentMapper.selectByPrimaryKey(staff.getDepartment().getDepId());
        return department.getAnnouncements();
    }

    @Override
    public List<Announcements> selectAnnsByLikeKey(Integer uId,String field,String value) {
        Map<String, Serializable> map = new HashMap<>();
        //组装模糊查询参数
        map.put("uId",uId);
        map.put("field",field);
        map.put("value","\'%"+value+"%\'");
        return annMapper.selectByVague(map);
    }

    @Override
    public Integer insertAnn(Integer uId,Announcements ann, List<String> depNames) {
        boolean isOk = false;
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        //总经理才能发布多部门可见公告  否则没有权限
        if (depNames.size() > 1){
            if (!staff.getPosition().getPositionName().equals("总经理")){
                return -1;
            }
        }
        //单部门发布公告只能在本部门发布  否则没有权限
        if (depNames.size() == 1){
            if (!staff.getDepartment().getDepName().equals(depNames.get(0))){
                return -1;
            }
        }
        //拥有公告发布权限的人才能发布公告，否则没有权限
        for (Power power : staff.getPowerList()) {
            if(power.getPowerName().equals("公告发布")){
                isOk = true;
            }
        }
        if (!isOk){
            return -1;
        }
        //添加公告  返回影响行数
        int insert = annMapper.insert(ann);
        if (insert !=0){
            //如果公告添加成功，遍历添加公告部门表数据
            for (String depName : depNames) {
                //通过部门名称获取id
                Department department = departmentMapper.selectByName(depName);
                AnnouncementsExtent annExtent = new AnnouncementsExtent();
                //set公告部门表数据
                annExtent.setAnnouncementsextentDepartmentid(department.getDepId());
                annExtent.setAnnouncementsextentAnnouncementsid(ann.getAnnouncementsId());
               //添加操作
                annExtentMapper.insert(annExtent);
            }
        }
        return insert;
    }

    @Override
    public int updateByPrimaryKey(Announcements ann) {
        return annMapper.updateByPrimaryKey(ann);
    }
}
