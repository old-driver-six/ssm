package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Announcements;

import java.util.List;

public interface AnnouncementsMapper {
    int deleteByPrimaryKey(Integer announcementsId);

    int insert(Announcements record);

    int insertSelective(Announcements record);

    Announcements selectByPrimaryKey(Integer announcementsId);

    int updateByPrimaryKeySelective(Announcements record);

    int updateByPrimaryKey(Announcements record);

    List<Announcements> selectByDepKey(Integer depId);
}