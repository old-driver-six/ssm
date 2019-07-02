package com.bj186.oas.service.pay.impl;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.mapper.Mapper;
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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service("payServiceImpl")
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper = null;
    @Resource
    private Mapper mapper = null;
    @Autowired
    private UserService userService;
    /**
     * 薪资录入
     * @param pay 薪资表
     * @return
     */
    @Override
    public String addPay(Pay pay) {
       try {

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
    @Override
    public Object selectAllPay(Integer pageNum,Integer pageSize){
        OAResoult<List<Pay>> listOAResoult =null;
        try {

            List<Pay>  pay =  payMapper.selectAllPay((pageNum-1)*pageSize,pageSize);
            Integer oas_pay = userService.selectCount("oas_pay");
            listOAResoult = new OAResoult<>();
            listOAResoult.setCode(0);
            listOAResoult.setMsg("");
            listOAResoult.setCount(oas_pay);
            listOAResoult.setData(pay);
        }catch (Exception e){
            e.printStackTrace();
        }

        return listOAResoult;
    }
    /**
     * 通过部门查询
     * @param
     * @return
     */
    @Override
    public Pay selectByPrimaryKey(String dep_name) {
        //调用部门service中的方法，通过部门名称获取id
        Department department = new Department();
        List<Staff> staffList = department.getStaffList();
        Integer staffId;
        Pay pay =null;
        for (Staff staff:staffList
        ) {
            staffId = staff.getStaffId();
            System.out.println(staffId);
//            pay = payMapper.selectByPrimaryKey(staffId);
        }
        return pay;

    }

    /**
     * 通过薪资Id更新
     * @param pay
     * @return
     */
    @Override
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


    /**
     * 通过Id删除薪资
     * @param payId
     * @return
     */
    @Override
    public String deleteByPrimaryKey(Integer payId) {
           int i = payMapper.deleteByPrimaryKey(payId);
           if (i>0){
               return "true";
           }else {
               return "false";
           }
    }

    /**
     * 通过员工id查询薪资
     * @param filed
     * @param value
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public Object selectStaffPay(String filed, String value, Integer pageSize, Integer pageNum) {
        /**
         * 通过前端传值：员工姓名查询员工id
         */
        List<Staff> select = userService.select(filed, value, pageSize, pageNum);
        Integer staffId = 0;
        Pay pay = new Pay();
        OAResoult<List<Pay>> oaResoult =null;
        for (Staff staff:select
             ) {
            staffId = staff.getStaffId();

            /**
             * 将员工的id传入薪资表，进行模糊查询薪资表
             */

        }
        System.out.println(staffId);
        pay.setPayStaffid(staffId);
        List<Pay> select1 = payMapper.select(pay);
        int size = select1.size();
        oaResoult = new OAResoult();
        oaResoult.setCode(0);
        oaResoult.setMsg("");
        oaResoult.setCount(size);
        oaResoult.setData(select1);
        System.out.println(oaResoult);
        return oaResoult;
    }


}