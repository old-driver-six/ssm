package com.bj186.oas.service.rent.impl;

import com.bj186.oas.mapper.RentMapper;
import com.bj186.oas.pojo.Rent;
import com.bj186.oas.service.rent.RentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("rentServiceImpl")
public class RentServiceImpl implements RentService {
    @Resource
    private RentMapper rentMapper;

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
        int insert = rentMapper.insert(rent);
        if (insert>0){
            return "true";
        }else {
            return "false";
        }
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
}
