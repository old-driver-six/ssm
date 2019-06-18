package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Files;

public interface FilesMapper {
    int deleteByPrimaryKey(Integer filesId);

    int insert(Files record);

    int insertSelective(Files record);

    Files selectByPrimaryKey(Integer filesId);

    int updateByPrimaryKeySelective(Files record);

    int updateByPrimaryKey(Files record);
}