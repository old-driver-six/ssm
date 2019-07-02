package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Pay;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PayMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer payId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Pay pay);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Pay record);
//
//    /**
//     * 查询所有
//     * @return
//     */
//    Integer countAll();
    /**
     *模糊查询
     * @mbggenerated 2019-06-18
     */

    List<Pay> select(Pay pay);

    /**
     * 查询薪资表所有信息
     */
    List<Pay> selectAllPay(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Integer payId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Pay pay);
}