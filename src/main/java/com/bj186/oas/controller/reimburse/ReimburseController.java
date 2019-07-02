package com.bj186.oas.controller.reimburse;

import com.bj186.oas.pojo.Reimburse;
import com.bj186.oas.service.reimburse.ReimburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("reimburse")
public class ReimburseController {
    @Autowired
    private ReimburseService reimburseService;
    @RequestMapping("selectAll")
    @ResponseBody
    public List<Reimburse> selectAll(){
        return reimburseService.selectAll();
    }
}
