package com.bj186.oas.service.personal;

import com.bj186.oas.pojo.Contract;

import java.util.List;

public interface ContractService {

    /**
     * 通过员工ID查询自己合同
     * @param uId
     * @param staffId
     * @return
     */
      Contract selectContractByStaffId(Integer uId,Integer staffId);

    /**
     * 查询所有合同
     * @param uId
     * @param pageNow
     * @param pageLimit
     * @return
     */
    List<Contract> selectAllConatracts(Integer uId,String pageNow, String pageLimit);

    /**
     * 按条件查询合同
     * @param uId
     * @param filed
     * @param value
     * @param pageNow
     * @param pageLimit
     * @return
     */
     List<Contract> selectContractsByRequirement(Integer uId,String filed,String value,String pageNow, String pageLimit);

    /**
     * 通过员工ID修改合同
     * @param uId
     * @param contract
     * @return
     */
     Integer updateContractByStaffId(Integer uId,Contract contract);

     /**
     * 统计所有合同数
     * @return String
     */
    String countAllContracts();


    /**
     *为一个员工生成一份新合同
     * @return
     */
    Integer updateByStaffId(Integer uId);
}
