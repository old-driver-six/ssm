package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Proof;

public interface ProofMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(Integer proofId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Proof record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Proof record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Proof selectByPrimaryKey(Integer proofId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Proof record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Proof record);
}