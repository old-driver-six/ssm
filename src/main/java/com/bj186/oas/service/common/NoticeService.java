package com.bj186.oas.service.common;

import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.Department;

import java.util.ArrayList;
import java.util.List;

public interface NoticeService {
    /**
     * 通过员工ID查询所有可见公告
     * @param uId
     * @return
     */
    List<Announcements> selectAnnsByKey(Integer uId);
    /**
     * 通过员工ID,条件查询可见公告
     * @param uId
     * @param field
     * @param value
     * @return
     */
    List<Announcements> selectAnnsByLikeKey(Integer uId,String field,String value);
    /**
     * 发布公告（包含权限判定）
     * @param ann
     *  @param depNames
     * @return
     */
    Integer insertAnn(Integer uId,Announcements ann, List<String> depNames);

    /**
     * 修改公告
     * @param ann
     * @return
     */
    int updateByPrimaryKey(Announcements ann);
}
