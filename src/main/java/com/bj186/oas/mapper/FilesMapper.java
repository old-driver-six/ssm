package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Files;

public interface FilesMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer filesId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Files record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Files record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Files selectByPrimaryKey(Integer filesId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Files record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Files record);
}