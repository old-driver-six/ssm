package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer usersId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer usersId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}