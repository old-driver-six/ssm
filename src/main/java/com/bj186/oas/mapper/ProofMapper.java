package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Proof;

public interface ProofMapper {
    int deleteByPrimaryKey(Integer proofId);

    int insert(Proof record);

    int insertSelective(Proof record);

    Proof selectByPrimaryKey(Integer proofId);

    int updateByPrimaryKeySelective(Proof record);

    int updateByPrimaryKey(Proof record);
}