package com.bj186.oas.controller.rent;

import com.bj186.oas.pojo.Rent;
import com.bj186.oas.service.rent.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("rent")
public class RentController {
    @Autowired
    private RentService rentService;
    @RequestMapping("deleteRent")
    @ResponseBody
    public String deleteRent(@RequestBody Integer rentId){
        return rentService.deleteByPrimaryKey(rentId);
    }
    @RequestMapping("insertRent")
    @ResponseBody
    public String insertRent(@RequestBody Rent rent){
//      return rentService.insert(rent);
        return null;
    }
    @RequestMapping("updateRent")
    @ResponseBody
    public String updateRent(Rent rent){
        return rentService.updateByPrimaryKey(rent);
    }
}
