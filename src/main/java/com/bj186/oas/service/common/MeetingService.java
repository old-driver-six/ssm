package com.bj186.oas.service.common;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.common.SelectAllBean;
import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.Meeting;

import java.util.List;

public interface MeetingService {
    /**
     * 通过员工ID查询所有可见会议
     * @param
     * @return
     */
    List<Meeting> selectMeetByKey(SelectAllBean selectAllBean);

    /**
     * 通过员工ID查询所有可见会议
     * @param
     * @return
     */
    OAResoult selectMyAll(Integer uId, Integer page, Integer limit,String field,String value);


    OAResoult update(Meeting meeting);

    Integer insert(Meeting meeting ,List<String> depNames);
//    /**
//     * 通过员工ID,条件查询会议
//     * @param uId
//     * @param field
//     * @param value
//     * @return
//     */
//    List<Meeting> selectMeetByLikeKey(Integer uId, String field, String value);
//    /**
//     * 召开会议（包含权限判定）
//     * @param
//     *  @param depNames
//     * @return
//     */
//    Integer insertMeet(Integer uId, Meeting meet, List<String> depNames);
//
//    /**
//     * 修改公告（包含可见部门列表）
//     * @param
//     * @return
//     */
//    int updateByPrimaryKey(Integer uId,  Meeting meet, List<String> depNames);
//    /**
//     * 通过员工ID查询 此员工召开的会议（我的会议）
//     * @param uId
//     * @return
//     */
//    OAResoult selectAnnsByUid(Integer uId, Integer page, Integer limit, String field, String value);
//    /**
//     * 查询会议详细信息
//     * @return
//     */
//    Announcements selectAnn(Integer annId);
}
