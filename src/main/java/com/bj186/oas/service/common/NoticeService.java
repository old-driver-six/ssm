package com.bj186.oas.service.common;

import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.Department;

import java.util.List;

public interface NoticeService {
    /**
     * 通过员工ID查询可见公告
     * @param uId
     * @return
     */
    Department selectDepByKey(Integer id);
}
