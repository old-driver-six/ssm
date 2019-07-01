package com.bj186.oas.controller.systemController;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.system.Dep;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Position;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.system.DepService;
import com.bj186.oas.service.system.PositionService;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping("/index")
    public String index() {
        return "system/position-manage";
    }
    /**
     * 查询全部部门信息
     * @return
     */
    @RequestMapping("/selectPosition")
    @ResponseBody
    public OAResoult selectPosition(){
        OAResoult<List<Position>> oaResoult = new OAResoult();
        List<Position> positionList = positionService.selectPosition();

        //放到返回类中
        oaResoult.setCode(0);
        oaResoult.setMsg("");
        oaResoult.setCount(positionList.size());
        oaResoult.setData(positionList);
        return oaResoult;
    }
}
