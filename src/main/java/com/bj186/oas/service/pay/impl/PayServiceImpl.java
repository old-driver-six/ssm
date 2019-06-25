package com.bj186.oas.service.pay.impl;

import com.bj186.oas.mapper.PayMapper;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Pay;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.pay.PayService;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("payServiceImpl")
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper = null;
    @Autowired
    private UserService userService;
    /**
     * 薪资录入
     * @param pay 薪资表
     * @return
     */
    @Transactional
    public String addPay(Pay pay) {
       try {

           List<Staff> select = userService.select("staff_name", "小明", 2, 3);
           Integer staffId =0;
           for (Staff staff:select
           ) {
               staffId = staff.getStaffId();
               System.out.println(staffId);
           }
           pay.setPayStaffid(staffId);
           int insert = payMapper.insert(pay);
           if (insert>0){
               System.out.println("添加成功");
               return "true";
           }
       }catch (Exception e){
           e.printStackTrace();
           System.out.println("数据有空值，不能添加到数据库");
       }
       return "false";
    }

    /**
     * 查询薪资表所有信息
     * @return
     */
    @Transactional
    public List<Pay> selectAllPay(){
        List<Pay> pay =null;
        try {

            pay =  payMapper.selectAllPay();

            System.out.println(pay);

        }catch (Exception e){
            e.printStackTrace();
        }

        return pay;
    }

    /**
     * 通过部门查询
     * @param
     * @return
     */
    @Transactional
    public Pay selectByPrimaryKey(Integer dep_name) {
        //调用部门service中的方法，通过部门名称获取id
        Department department = new Department();
        List<Staff> staffList = department.getStaffList();
        Integer staffId;
        Pay pay =null;
        for (Staff staff:staffList
        ) {
            staffId = staff.getStaffId();
            System.out.println(staffId);
            pay = payMapper.selectByPrimaryKey(staffId);
        }
        return pay;

    }

    /**
     * 通过薪资Id更新
     * @param pay
     * @return
     */
    @Transactional
    public String updateByPrimaryKey(Pay pay){
        int i = payMapper.updateByPrimaryKey(pay);
        if (i>0){
            System.out.println("薪资修改成功");
            return "true";
        }else {
            System.out.println("薪资修改失败");
            return "false";
        }


    }

//    /**
//     * 通过薪资Id更新查询数据
//     * @param payId
//     * @return
//     */
//    @Transactional
//    public Integer updateByPrimaryKeySelective(Integer payId) {
//        return payMapper.updateByPrimaryKeySelective(payId);
//
//    }

    /**
     * 通过Id删除薪资
     * @param payId
     * @return
     */
    @Transactional
    public String deleteByPrimaryKey(Integer payId) {
           int i = payMapper.deleteByPrimaryKey(payId);
           if (i>0){
               return "true";
           }else {
               return "false";
           }
    }
//
//    @Override
//    public Integer insertSelective(Pay pay) {
//        return payMapper.insertSelective(pay);
//
//    }


}