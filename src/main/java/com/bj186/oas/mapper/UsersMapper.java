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

    //停职
    int suspension(Integer usersID);
    int office(Integer staffID);
    int lizhi(Integer staffID);
    //离职
    int Departure(Integer usersID);
    //复职
    int Reinstatement(Integer usersID);


    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Users record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Users selectByPrimaryKey(String usersPhone);
    Users select(Integer staffid);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByStaffId(Users record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Users record);
}