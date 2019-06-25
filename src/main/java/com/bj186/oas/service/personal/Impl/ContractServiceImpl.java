package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.mapper.ContractMapper;
import com.bj186.oas.mapper.StaffMapper;
import com.bj186.oas.pojo.Contract;


import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Position;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.personal.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("ContractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private StaffMapper staffMapper;
    /**
     *当前员工通过员工ID查询合同
     * @param staffId
     * @return Contract
     */
    @Override
    public Contract selectContractByStaffId(Integer uId,Integer staffId) {
        //获取当前用户的部门
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        Department staffDepartment = staff.getDepartment();
        Integer depId = staffDepartment.getDepId();
        if (depId == 1){
            //人事部可以根据输入ID随意查询合同
            Contract contract = contractMapper.selectContractByStaffId(staffId);
            return contract;
        }else {
            //非人事部只能查询自己的合同
            Contract contract = contractMapper.selectContractByStaffId(uId);
            return  contract;
        }

    }

    /**
     *  查询当前合同里的员工信息
     * @param staffId
     * @return
     */
    @Override
    public Staff selectStaffInTheContract(Integer staffId) {
        Contract contract = contractMapper.selectContractByStaffId(staffId);
        Staff staff = contract.getStaff();
       return  staff;
    }

    /**
     * 查询所有(在职或者离职)员工合同
     * @param uId
     * @param userState
     * @param pageNow
     * @param pageLimit
     * @return
     */
    @Override
    public List<Contract> selectAllConatracts(Integer uId,String userState, String pageNow, String pageLimit) {
        //获取当前用户的部门
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        Department staffDepartment = staff.getDepartment();
        Integer depId = staffDepartment.getDepId();
        if (depId == 1){
            //只有人事部可以查询所有合同
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("uState",userState);
            map.put("field",null);
            map.put("value", "\'%"+null+"%\'");
            map.put("LimitParameter_1",(Integer.parseInt(pageNow)-1)*Integer.parseInt(pageLimit));
            map.put("LimitParameter_2",Integer.parseInt(pageLimit));
            List<Contract>  contractList =contractMapper.selectContractsByRequirement(map);
            return contractList;}
        else {
            return  null;
        }
    }

    /**
     * 按条件查询合同
     * @param filed
     * @param value
     * @param pageNow
     * @param pageLimit
     * @return contractsList
     */
    @Override
    public List<Contract> selectContractsByRequirement(Integer uId,String filed,String value,String pageNow,String pageLimit) {
        //获取当前用户的部门
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        Department staffDepartment = staff.getDepartment();
        Integer depId = staffDepartment.getDepId();
        if(depId == 1){
            //人事部可以按条件查询合同
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("field",filed);
            map.put("value", "\'%"+value+"%\'");
            map.put("LimitParameter_1",(Integer.parseInt(pageNow)-1)*Integer.parseInt(pageLimit));
            map.put("LimitParameter_2",Integer.parseInt(pageLimit));
            List<Contract>  contractList =contractMapper.selectContractsByRequirement(map);
            return contractList;
        }else {
            return null;
        }
    }


    /**
     * 通过员工ID修改合同
     * @param contract
     * @return Integer
     */
    @Override
    public Integer updateContractByStaffId(Integer uId,Contract contract) {
        //获取当前用户的部门和职能,只有人事经理可以修改合同内容
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        Department staffDepartment = staff.getDepartment();
        Integer depId = staffDepartment.getDepId();
        Position position = staff.getPosition();
        Integer positionId = position.getPositionId();
        if (depId==1&&positionId==2){
        Integer integer = contractMapper.updateByStaffId(contract);
        return integer;
        } else{
           return  null;
        }
    }

    /**
     * 统计所有合同数
     * @return String
     */
    @Override
    public String countAllContracts() {
        String counts = contractMapper.countAllContracts();
        return counts;
    }

    /**
     *
     * 根据员工ID生成一份新合同
     * @param uId
     * @param record
     * @return
     */
    @Override
    public Integer inserteContractByStaffId(Integer uId,Contract record) {
        //获取当前用户的部门和职能,只有人事经理可以生成新合同
        Staff staff = staffMapper.selectByPrimaryKey(uId);
        Department staffDepartment = staff.getDepartment();
        Integer depId = staffDepartment.getDepId();
        Position position = staff.getPosition();
        Integer positionId = position.getPositionId();
        if (depId==1&&positionId==2){
            int insert = contractMapper.insert(record);
            return  insert;
        }else {
            return  null;
        }
    }

    /**
     * 无条件生成合同(级联生成时时使用)
     * @param record
     * @return
     */
    @Override
    public Integer insertContract(Contract record) {
        return contractMapper.insert(record);
    }


}
