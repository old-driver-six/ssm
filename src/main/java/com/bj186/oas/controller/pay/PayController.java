package com.bj186.oas.controller.pay;

import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.pojo.Pay;
import com.bj186.oas.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/pay")
@SessionAttributes(value = {"sessionVal"},types = {String.class})
public class PayController {
    @Autowired
    private PayService payService;

    @RequestMapping("/selectAll")
    public String toHTML(){
        return "selectAll";//重定向要加：redirect。（表单，和上传文件用）
    }
    @RequestMapping("/addpay")
    public String toHTML2(){
        return "addpay";//重定向要加：redirect。（表单，和上传文件用）
    }
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
            String s = payService.addPay(pay);
            System.out.println(s);
            return s;
        }
    }

    /**
     * 查询所有薪资表信息
     * @return
     */
    @RequestMapping("selectPay")
    @ResponseBody
    public List<Pay> selectAllPay(){
        List<Pay> pays = payService.selectAllPay();
        System.out.println(pays);
        return pays;

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
     * @param pay
     * @return
     */
    @RequestMapping("updateByPrimaryKey")
    @ResponseBody
    public String updateByPrimaryKey(@RequestBody Pay pay){
        return payService.updateByPrimaryKey(pay);

    }

    /**
     * 删除
     * @param payId
     * @return
     */
    @RequestMapping("deleteByPrimaryKey")
    @ResponseBody
    public String deleteByPrimaryKey(Integer payId){
        return payService.deleteByPrimaryKey(payId);
    }
}
