package com.bj186.oas.controller.pay.impl;
import com.bj186.oas.controller.pay.PayController;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Pay;
import com.bj186.oas.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/pay")
public class PayControllerImpl implements PayController {
    @Autowired
    private PayService payService;

    /**
     * 薪资添加
     * @param pay 薪资表
     * @return
     * @throws NullNameException 空值处理类
     */
    @RequestMapping("/addPay")
    @ResponseBody
    public String addPay(@RequestBody Pay pay) throws NullNameException {
        System.out.println(pay);
//       利用异常，改写操作
        if (pay.getPayId().equals("")) {
            throw new NullNameException("薪资id不能为空");
        } else {
            Integer integer = payService.addPay(pay);
            System.out.println(integer);
            return "ture";

        }
    }

    /**
     * 查询所有薪资表信息
     * @return
     */
    @RequestMapping("selectPay")
    @ResponseBody
    public String selectAllPay(){
        Pay pay = payService.selectAllPay();
        System.out.println(pay);
        return "selectPay";

    }

    /**
     * 通过薪资id查询薪资
     * @param payId 薪资id
     * @return
     */
    @RequestMapping("selectByPrimaryKey")
    @ResponseBody
    public Pay selectByPrimaryKey(@RequestBody Integer payId) {
        return payService.selectByPrimaryKey(payId);

    }

    /**
     * 修改
     * @param payId 薪资id
     * @return
     */
    @RequestMapping("updateByPrimaryKey")
    @ResponseBody
    public Integer updateByPrimaryKey(@RequestBody Integer payId){
        return payService.updateByPrimaryKey(payId);

    }

    /**
     * 删除
     * @param payId
     * @return
     */
    @RequestMapping("deleteByPrimaryKey")
    @ResponseBody
    public Integer deleteByPrimaryKey(Integer payId){
        return payService.deleteByPrimaryKey(payId);
    }
}
