package com.bj186.oas.mapper;

import com.bj186.oas.pojo.AnnouncementsExtent;

public interface AnnouncementsExtentMapper {
    int deleteByPrimaryKey(Integer announcementsextentId);

    int insert(AnnouncementsExtent record);

    int insertSelective(AnnouncementsExtent record);

    AnnouncementsExtent selectByPrimaryKey(Integer announcementsextentId);

    int updateByPrimaryKeySelective(AnnouncementsExtent record);

    int updateByPrimaryKey(AnnouncementsExtent record);
}