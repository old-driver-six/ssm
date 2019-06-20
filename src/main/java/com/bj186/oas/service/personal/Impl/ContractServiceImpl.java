package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.mapper.ContractMapper;
import com.bj186.oas.pojo.Contract;


import com.bj186.oas.service.personal.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service("ContractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    /**
     * 通过员工ID查询合同
     * @param staffId
     * @return Contract
     */
    @Override
    public Contract selectContractByStaffId(Integer staffId) {
        Contract contract = contractMapper.selectContractByStaffId(staffId);
        return contract;
    }

    /**
     * 查询所有合同(分页查询)
     * @param pageNow
     * @param pageLimit
     * @return List<Contract>
     */
    @Override
    public List<Contract> selectAllContracts(String pageNow, String pageLimit) {


        return null;
    }

    /**
     * 通过员工ID修改合同
     * @param contract
     * @return Integer
     */
    @Override
    public Integer updateContractByStaffId(Contract contract) {
        Integer integer = contractMapper.updateByStaffId(contract);
        return integer;
    }
}
