package com.bj186.oas.controller.personnelController;

import com.bj186.oas.pojo.Contract;

import com.bj186.oas.service.personal.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/personnel")
public class ContractController {

    @Autowired
    private ContractService contractService;
    @RequestMapping("/selectStaffContractById")
    @ResponseBody
    public Contract selectContractByStaffId(){
        return contractService.selectContractByStaffId(10001);
    }
}
