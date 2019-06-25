package com.bj186.oas.service.fixed;

import com.bj186.oas.pojo.Fixed;

import java.util.List;


public interface FixedService {
    String deleteByPrimaryKey(Integer fixId);
    String insert(Fixed fixed);
    List<Fixed> selectAllFixed();
    Fixed selectByPrimaryKey(Integer fixId);
    String updateByPrimaryKey(Fixed fixed);

}
