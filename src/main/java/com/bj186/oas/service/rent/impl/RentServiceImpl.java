package com.bj186.oas.service.rent.impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.mapper.RentMapper;
import com.bj186.oas.pojo.Fixed;
import com.bj186.oas.pojo.Rent;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.pojo.personalpojo.Page;
import com.bj186.oas.service.fixed.FixedService;
import com.bj186.oas.service.rent.RentService;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("rentServiceImpl")
public class RentServiceImpl implements RentService {
    @Resource
    private RentMapper rentMapper;
    @Autowired
    private FixedService fixedService;
    @Autowired
    private UserService userService;
    /**
     * 租赁的删除
     * @param rentId 租赁id
     * @return
     */
    @Transactional
    public String deleteByPrimaryKey(Integer rentId) {
        int i = rentMapper.deleteByPrimaryKey(rentId);
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     *
     * 租赁的添加
     * @param rent 租赁表
     * @return
     */
    @Transactional
    public String insert(Rent rent) {
        /**
         * 前端传值有员工id(通过查询员工姓名方法获取员工id)
         * 租赁数量和物品资产id(在资产表中修改租赁的状态)
         *租赁数量和物品资产id还用于租赁表的添加
         */
//            List<Staff> select = userService.select(filed, value, pageSize, pageNum);
//            Integer staffId=0;
            String succes=null;
//            for (Staff staff:select
//                 ) {
//                staffId = staff.getStaffId();
//            }
//            if (staffId!=0){
//                String s = fixedService.updateByPrimaryKey(fixed);
//                rent.setRentFixid(fixed.getFixId());
//                if (s.equals("true")){
//                    rent.setRentStaffId(staffId);
        Fixed fixed = new Fixed();
        Integer rentNumber = rent.getRentNumber();
        fixed.setFixRentNumber(rentNumber);
        fixedService.updateByPrimaryKey(fixed);
        int insert = rentMapper.insert(rent);
                    if (insert>0){
                        succes= "true";
                    }else {
                        succes= "false";
                    }
//                }else {
//                    System.out.println("资产修改失败");
//                }
//            }else {
//                System.out.println("用户不存在");
//            }
            return succes;
    }

    /**
     * 租赁的查询
     * @param rentId
     * @return
     */
    @Transactional
    public Rent selectByPrimaryKey(Integer rentId) {
        return rentMapper.selectByPrimaryKey(rentId);

    }

    /**
     * 租赁的修改
     * @param rent
     * @return
     */
    @Transactional
    public String updateByPrimaryKey(Rent rent) {
        int i = rentMapper.updateByPrimaryKey(rent);
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }

    @Override
    public Object selectAll(Integer pageNum, Integer pageSize) {
        OAResoult<List<Rent>> listOAResoult =null;
        try {
            List<Rent> rents = rentMapper.selectAll((pageNum-1)*pageSize,pageSize);
            Integer oas_rent = userService.selectCount("oas_rent");
            listOAResoult =new OAResoult<>();
            listOAResoult.setCode(0);
            listOAResoult.setMsg("");
            listOAResoult.setCount(oas_rent);
            listOAResoult.setData(rents);
        }catch (Exception e){
            e.printStackTrace();
        }
        return listOAResoult;
    }
}
