package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Contract;

public interface ContractMapper {
    /**
     *
     * @mbggenerated 2019-06-18
     */
    int deleteByPrimaryKey(String contractId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insert(Contract record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int insertSelective(Contract record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    Contract selectByPrimaryKey(String contractId);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeySelective(Contract record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKeyWithBLOBs(Contract record);

    /**
     *
     * @mbggenerated 2019-06-18
     */
    int updateByPrimaryKey(Contract record);
}