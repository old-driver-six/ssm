package com.bj186.oas.service.fixed.impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.mapper.FixedMapper;
import com.bj186.oas.pojo.Fixed;
import com.bj186.oas.service.fixed.FixedService;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("fixedServiceImpl")
public class FixedServiceImpl implements FixedService {
    @Resource
    private FixedMapper fixedMapper;
    @Autowired
    private UserService userService;
    /**
     * 通过id删除资产
     * @param fixId
     * @return
     */
    @Override
    public String deleteByPrimaryKey(Integer fixId) {
        int i = fixedMapper.deleteByPrimaryKey(fixId);
        if (i>0){
            System.out.println("删除成功");
            return "true";
        }
        else {
            System.out.println("删除失败");
            return "false";
        }
    }

    /**
     * 添加资产
     * @param fixed
     * @return
     */
    @Override
    public String insert(Fixed fixed) {
        int insert = fixedMapper.insert(fixed);
        if (insert>0){
            System.out.println("添加成功");
            return "true";
        }else {
            System.out.println("添加失败");
            return "false";
        }
    }

    /**
     * 查询所有资产
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Object selectAllFixed(Integer pageNum,Integer pageSize) {
        OAResoult<List<Fixed>> fixedOAResoult =null;
        try {
            List<Fixed> fixed = fixedMapper.selectAllFixed((pageNum-1)*pageSize,pageSize);
            Integer oas_fixed = userService.selectCount("oas_fixed");
            fixedOAResoult = new OAResoult<>();
            fixedOAResoult.setCode(0);
            fixedOAResoult.setMsg("");
            fixedOAResoult.setCount(oas_fixed);
            fixedOAResoult.setData(fixed);
        }catch (Exception e){
            e.printStackTrace();
        }
        return fixedOAResoult;

    }

    @Override
    public Fixed selectByPrimaryKey(Integer fixId) {
        return fixedMapper.selectByPrimaryKey(fixId);
    }

    /**
     * 修改资产
     * @param fixed
     * @return
     */
    @Override
    public String updateByPrimaryKey(Fixed fixed) {
        int i = fixedMapper.updateByPrimaryKey(fixed);
        if (i>0){
            System.out.println("修改成功");
            return "true";
        }else {
            System.out.println("修改失败");
            return "false";
        }
    }
}
