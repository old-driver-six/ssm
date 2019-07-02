package com.bj186.oas.service.rent;

import com.bj186.oas.pojo.Fixed;
import com.bj186.oas.pojo.Rent;

public interface RentService {
    String deleteByPrimaryKey(Integer rentId);
    String insert(Rent rent, Fixed fixed, String filed, String value, Integer pageSize, Integer pageNum);
    Rent selectByPrimaryKey(Integer rentId);
    String updateByPrimaryKey(Rent record);
}
