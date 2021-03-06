package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Staff;

import java.util.List;

public interface DepartmentMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer depId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Department record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Department record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Department selectByPrimaryKey(Integer depId);

    Department selectById(Integer depId);

    List<Department> selectDep();

    List<Staff> selectDepStaff(String depName);
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Department record);
    Department selectByName(String depName);

}