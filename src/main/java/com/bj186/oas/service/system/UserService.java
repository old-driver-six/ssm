package com.bj186.oas.service.system;

import com.bj186.oas.pojo.Staff;

import java.util.List;

public interface UserService {

   Staff selectByPrimaryKey(Integer staffID);
   Staff select(String filed,String value,Integer pageSize,Integer pageNum);
   String insert(Staff staff);
   String update(Staff staff);
   String delete(Integer staffID);

}
