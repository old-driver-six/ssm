package com.bj186.oas.service.fixed.impl;

import com.bj186.oas.mapper.FixedMapper;
import com.bj186.oas.pojo.Fixed;
import com.bj186.oas.service.fixed.FixedService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("fixedServiceImpl")
public class FixedServiceImpl implements FixedService {
    @Resource
    private FixedMapper fixedMapper;

    /**
     * 通过id删除资产
     * @param fixId
     * @return
     */
    @Transactional
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

    @Transactional
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

    @Transactional
    public List<Fixed> selectAllFixed() {
        List<Fixed> fixeds=null;
        try {
            fixeds = fixedMapper.selectAllFixed();
        }catch (Exception e){
            e.printStackTrace();
        }
        return fixeds;

    }

    @Transactional
    public Fixed selectByPrimaryKey(Integer fixId) {
        return fixedMapper.selectByPrimaryKey(fixId);
    }

    @Transactional
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
