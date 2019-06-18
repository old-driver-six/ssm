package com.bj186.oas.mapper;

import com.bj186.oas.pojo.AnnouncementsExtent;

public interface AnnouncementsExtentMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer announcementsextentId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(AnnouncementsExtent record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(AnnouncementsExtent record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    AnnouncementsExtent selectByPrimaryKey(Integer announcementsextentId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(AnnouncementsExtent record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(AnnouncementsExtent record);
}