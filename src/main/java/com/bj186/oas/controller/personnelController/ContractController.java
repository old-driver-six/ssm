package com.bj186.oas.controller.personnelController;

import com.bj186.oas.pojo.Contract;

import com.bj186.oas.service.personal.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/personnel")
public class ContractController {

    @Autowired
    private ContractService contractService;

    /**
     * 通过员工ID查询合同
     */
    @RequestMapping("/selectStaffContractById")
    @ResponseBody
    public Contract selectContractByStaffId(){
        return contractService.selectContractByStaffId(10001,10001);
    }

    /**
     *查询所有合同(分页查询)
     */
    @RequestMapping("/selectAllContracts")
    @ResponseBody
    public List<Contract> selectAllConatracts(){
        String count = contractService.countAllContracts();
        System.out.println(count);
    return  contractService.selectAllConatracts(null,"1","10");
    }

    public Integer updateContractByStaffId(){
        Contract contract = new Contract();
        Integer integer=contractService.updateContractByStaffId(null,contract);
        return integer;
    }

}
