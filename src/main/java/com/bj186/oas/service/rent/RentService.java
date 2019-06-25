package com.bj186.oas.service.rent;

import com.bj186.oas.pojo.Rent;

public interface RentService {
    String deleteByPrimaryKey(Integer rentId);
    String insert(Rent record);
    Rent selectByPrimaryKey(Integer rentId);
    String updateByPrimaryKey(Rent record);
}
