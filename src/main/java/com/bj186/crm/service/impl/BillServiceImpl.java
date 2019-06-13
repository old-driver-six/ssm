package com.bj186.crm.service.impl;

import com.bj186.crm.mapper.BillMapper;
import com.bj186.crm.pojo.Bill;
import com.bj186.crm.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("billService")
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;
    public Bill selectBillById(Long id) {
        Bill bill = billMapper.selectBillById(15573016752669242l);
        return bill;
    }
}
