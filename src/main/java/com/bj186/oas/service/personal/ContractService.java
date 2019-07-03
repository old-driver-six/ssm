package com.bj186.oas.service.personal;

import com.bj186.oas.pojo.Contract;
import com.bj186.oas.pojo.Staff;

import java.util.List;

public interface ContractService {

    /**
     * 通过员工ID查询自己合同
     * @param uId
     * @param staffId
     * @return
     */
      Contract selectContractByStaffId(Integer uId, Integer staffId);

    /**
     *  查询当前合同里的员工信息
     * @param staffId
     * @return
     */
    Staff selectStaffInTheContract(Integer staffId);

    /**
     * 查询所有(在职或者离职)员工合同
     * @param uId
     * @param userState
     * @param pageNow
     * @param pageLimit
     * @return
     */
    List<Contract> selectAllConatracts(Integer uId, String userState,String pageNow, String pageLimit);

    /**
     * 按条件查询合同
     * @param uId
     * @param filed
     * @param value
     * @param pageNow
     * @param pageLimit
     * @return
     */
     List<Contract> selectContractsByRequirement(Integer uId, String filed, String value, String pageNow, String pageLimit);

    /**
     * 通过员工ID修改合同
     * @param uId
     * @param contract
     * @return
     */
     Integer updateContractByStaffId(Integer uId, Contract contract);

     /**
     * 统计所有合同数
     * @return
     */
    Integer countAllContracts();


    /**
     *为一个员工生成一份新合同
     * @return
     */
    Integer inserteContractByStaffId(Integer uId, Contract record);

    /**
     * 生成合同
     * @param record
     * @return
     */
    Integer insertContract(Contract record);



}
