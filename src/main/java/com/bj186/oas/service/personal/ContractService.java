package com.bj186.oas.service.personal;

import com.bj186.oas.pojo.Contract;

import java.util.List;

public interface ContractService {

    /**
     * 通过员工ID查询合同
     * @param staffId
     * @return Contract
     */
    public Contract selectContractByStaffId(Integer staffId);

    /**
     * 查询所有合同(分页查询)
     * @param pageNow
     * @param pageLimit
     * @return List<Contract>
     */
    public List<Contract> selectAllContracts(String pageNow, String pageLimit);

    /**
     * 通过员工ID修改合同
     * @param contract
     * @return Integer
     */
    public Integer updateContractByStaffId(Contract contract);
}
