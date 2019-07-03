package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Rent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer rentId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Rent record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Rent record);
    /**
     * 查询所有
     */
    List<Rent> selectAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Rent selectByPrimaryKey(Integer rentId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Rent record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Rent record);
}