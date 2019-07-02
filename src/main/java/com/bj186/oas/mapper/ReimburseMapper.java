package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Reimburse;

import java.util.List;

public interface ReimburseMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer reimId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Reimburse record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Reimburse record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Reimburse selectByPrimaryKey(Integer reimId);
    /**
     * 查询所有
     */
    List<Reimburse> selectAll();

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Reimburse record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Reimburse record);
}