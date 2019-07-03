package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Contract;

import java.util.List;
import java.util.Map;

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
    Contract selectContractByStaffId(Integer staffId);

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
    int updateByStaffId(Contract record);

    /**
     *
     * @return
     */
    Integer countAllContracts();

    /**
     *
     * @param map
     * @return
     */
    List<Contract> selectContractsByRequirement(Map map);
}