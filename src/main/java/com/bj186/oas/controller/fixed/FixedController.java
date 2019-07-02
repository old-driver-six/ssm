package com.bj186.oas.controller.fixed;


import com.bj186.oas.pojo.Fixed;
import com.bj186.oas.service.fixed.FixedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/fixed")
public class FixedController {
    @Autowired
    private FixedService fixedService;
    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public String deleteByPrimaryKey(@RequestBody Integer fixId) {
        return fixedService.deleteByPrimaryKey(fixId);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(@RequestBody Fixed fixed) {
        return fixedService.insert(fixed);
    }


    public String selectByPrimaryKey(Integer fixId) {
        return null;
    }

    @RequestMapping("selectAllFixed")
    @ResponseBody
    public Object selectAllFixed(@RequestParam("page")  Integer pageNum, @RequestParam("limit") Integer pageSize) {
        return fixedService.selectAllFixed(pageNum, pageSize);


    }

    @RequestMapping("updateByPrimaryKey")
    @ResponseBody
    public String updateByPrimaryKey(@RequestBody Fixed fixed) {
        return fixedService.updateByPrimaryKey(fixed);
    }
}
