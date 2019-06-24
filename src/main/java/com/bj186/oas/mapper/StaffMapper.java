package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Staff;

import java.util.List;
import java.util.Map;

public interface StaffMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer staffId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Staff record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Staff record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Staff selectByPrimaryKey(Integer staffId);

    List<Staff> select(Map<String, Object> map);

    List<Staff> selectAll();

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Staff record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Staff record);
}