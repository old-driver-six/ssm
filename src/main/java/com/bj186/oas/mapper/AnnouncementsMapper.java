package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Announcements;

public interface AnnouncementsMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer announcementsId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Announcements record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Announcements record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Announcements selectByPrimaryKey(Integer announcementsId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Announcements record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Announcements record);
}