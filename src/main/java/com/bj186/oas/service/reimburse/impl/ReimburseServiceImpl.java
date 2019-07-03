package com.bj186.oas.service.reimburse.impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.mapper.ReimburseMapper;
import com.bj186.oas.pojo.Reimburse;
import com.bj186.oas.service.reimburse.ReimburseService;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service("reimburseServiceImpl")
public class ReimburseServiceImpl implements ReimburseService {
    @Resource
    private ReimburseMapper reimburseMapper;
    @Autowired
    private UserService userService;
    @Override
    public Reimburse selectByPrimaryKey(Integer reimId) {
        return null;
    }

    @Override
    public Object selectAll(Integer pageNum,Integer pageSize) {
        List<Reimburse> reimburses = reimburseMapper.selectAll((pageNum-1)*pageSize,pageSize);
        Integer oas_reimburse = userService.selectCount("oas_reimburse");
        OAResoult<List<Reimburse>> listOAResoult = new OAResoult<>();
        listOAResoult.setCode(0);
        listOAResoult.setMsg("");
        listOAResoult.setCount(oas_reimburse);
        listOAResoult.setData(reimburses);
        return listOAResoult;
    }
}
