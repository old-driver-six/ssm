package com.bj186.crm.test;

import com.bj186.crm.pojo.Bill;
import com.bj186.crm.service.BillService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BillTest {
    ClassPathXmlApplicationContext context;
    BillService billService;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("config/spring.xml");
        billService = context.getBean("billService", BillService.class);
    }
    @Test
    public void selectBillTest(){
        Bill bill = billService.selectBillById(15573016752669242l);
        System.out.println(bill);
    }
}
