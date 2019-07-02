package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Fixed;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FixedMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer fixId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Fixed fixed);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Fixed record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Fixed selectByPrimaryKey(Integer fixId);
    /**
     * 查询所有固定资产
     */
    List<Fixed> selectAllFixed(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Fixed record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Fixed record);
}