package com.bj186.oas.controller.personnelController;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.common.StaffIdBean;
import com.bj186.oas.pojo.Contract;

import com.bj186.oas.service.personal.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/personnel")
public class ContractController {

    @Autowired
    private ContractService contractService;

    /**
     *查询所有合同(分页查询)
     */
    @RequestMapping("/selectAllContracts")
    @ResponseBody
    public OAResoult selectAllConatracts(
            @RequestParam("uId") Integer uId,
            @RequestParam("page") String pageNow,
            @RequestParam("limit") String pageLimit
    ){
        Integer count = contractService.countAllContracts();
        System.out.println(count);
        List<Contract> contractList = contractService.selectAllConatracts(uId,null, pageNow, pageLimit);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCount(count);
        oaResoult.setCode(0);
        oaResoult.setMsg("");
        oaResoult.setData(contractList);
        return oaResoult;
    }


    @RequestMapping("/selectContractsByRequirement")
    @ResponseBody
    public  OAResoult selectContractsByRequirement(
            @RequestParam("uId") Integer uId,
            @RequestParam("staffId") String staffId,
            @RequestParam("userState") String userState,
            @RequestParam("page") String pageNow,
            @RequestParam("limit") String pageLimit

    ){
        List<Contract> contractList = contractService.selectContractsByRequirement(uId,userState,"staff_id",staffId,pageNow,pageLimit);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCount(contractList.size());
        oaResoult.setCode(0);
        oaResoult.setMsg("");
        oaResoult.setData(contractList);
        System.out.println(contractList);
        return oaResoult;

    }

    @RequestMapping("/selectContractByStaffId")
    @ResponseBody
    public  Contract selectContractByStaffId(
            @RequestBody StaffIdBean staffIdBean
            ){
        Contract contract = contractService.selectContractByStaffId(staffIdBean.getuId(), staffIdBean.getStaffId());
        return contract;
    }

    /**
     * 根据员工ID修改合同内容
     * @return
     */
    public Integer updateContractByStaffId(){
        Contract contract = new Contract();
        Integer integer=contractService.updateContractByStaffId(null,contract);
        return integer;
    }

    public  OAResoult selectContractsOfCurrentStaffs(){
        return null;
    }

    public OAResoult selectContractsOfFormeStaffs(){
        return null;
    }



}
