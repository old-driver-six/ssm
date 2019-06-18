package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Contract;

public interface ContractMapper {
    int deleteByPrimaryKey(String contractId);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(String contractId);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKeyWithBLOBs(Contract record);

    int updateByPrimaryKey(Contract record);
}