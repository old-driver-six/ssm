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
        Department department = staff.getDepartment();
        //通过部门进一步查询公告列表
        if(department.getDepId() != 3) {
           //本部门只能查看本部门可见公告
            department = departmentMapper.selectByPrimaryKey(staff.getDepartment().getDepId());
            return department.getAnnouncements();
        }else {
            //董事局可以查看所有公告
            List<Announcements> announcements = annMapper.selectAll();
            return announcements;
        }

    }

    @Override
    public List<Announcements> selectAnnsByLikeKey(Integer uId,String field,String value) {
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        Department department = staff.getDepartment();
        if(department.getDepId() != 3){
            //普通部门部门内公告模糊查询
            Map<String, Serializable> map = new HashMap<>();
            //组装模糊查询参数
            map.put("depId",department.getDepId());
            map.put("field",field);
            map.put("value","\'%"+value+"%\'");
            return annMapper.selectByDepIdVague(map);
        }else {
            //董事局全部公告模糊查询
            Map<String, Serializable> map = new HashMap<>();
            //组装模糊查询参数
            map.put("field",field);
            map.put("value","\'%"+value+"%\'");
            return annMapper.selectAllVague(map);
        }
    }

    @Override
    public Integer insertAnn(Integer uId,Announcements ann, List<String> depNames) {
        //权限判定
        Integer integer = judgePower(uId, depNames);
        //无权限
        if (integer !=0){
            return -1;
        }
        //添加公告  返回影响行数
        int insert = annMapper.insert(ann);
        if (insert !=0){
            //如果公告添加成功，遍历添加公告部门表数据
            insertAnnExtent(ann.getAnnouncementsId(),depNames);
        }
        return insert;
    }

    @Override
    public int updateByPrimaryKey(Integer uId,Announcements ann, List<String> depNames) {
        Integer integer = judgePower(uId, depNames);
        //无权限
        if (integer !=0){
            return -1;
        }
        //修改公告资料
        int i = annMapper.updateByPrimaryKey(ann);
        List<AnnouncementsExtent> annExtents = annExtentMapper.selectByAnnId(ann.getAnnouncementsId());
        //删除修改之前的可见部门
        for (AnnouncementsExtent annExtent : annExtents) {
            annExtentMapper.deleteByPrimaryKey(annExtent.getAnnouncementsextentId());
        }
        //增加修改之后的可见部门
        insertAnnExtent(ann.getAnnouncementsId(),depNames);
        return i;

    }

    @Override
    public List<Announcements> selectAnnsByNotifier(Integer uId) {
        List<Announcements> announcements = annMapper.selectAnnsByNotifier(uId);
        return announcements;
    }


    public Integer judgePower(Integer uId,List<String> depNames){
        boolean isOk = false;
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        //董事长才能发布多部门可见公告  否则没有权限
        if (depNames.size() > 1){
            if (!staff.getDepartment().getDepName().equals("董事局")){
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
        }else {
            return 0;
        }
    }
    /**
     * 通过公告id和部门名列表添加中间表数据
     * @param annId
     * @param depNames
     */
    public void insertAnnExtent(Integer annId,List<String> depNames){
        //如果公告添加成功，遍历添加公告部门表数据
        for (String depName : depNames) {
            //通过部门名称获取id
            Department department = departmentMapper.selectByName(depName);
            AnnouncementsExtent annExtent = new AnnouncementsExtent();
            //set公告部门表数据
            annExtent.setAnnouncementsextentDepartmentid(department.getDepId());
            annExtent.setAnnouncementsextentAnnouncementsid(annId);
            //添加操作
            annExtentMapper.insert(annExtent);
        }
    }
}
