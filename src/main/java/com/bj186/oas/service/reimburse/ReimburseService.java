package com.bj186.oas.service.reimburse;

import com.bj186.oas.pojo.Reimburse;

import java.util.List;

public interface ReimburseService {
    Reimburse selectByPrimaryKey(Integer reimId);
    Object selectAll(Integer pageNum,Integer pageSize);
}
