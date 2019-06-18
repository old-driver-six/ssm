package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Users;

public interface UsersMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer usersId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Users record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Users record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Users selectByPrimaryKey(Integer usersId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Users record);
}