package com.bj186.oas.service.system;

import com.bj186.oas.pojo.Staff;
import com.bj186.oas.pojo.Users;

import java.util.List;

public interface UserService {

   Staff selectByPrimaryKey(Integer staffID);
   List<Staff> select(String filed, String value, Integer pageSize, Integer pageNum);
   List<Staff> selectAll();
   String insert(Staff staff);
   String update(Staff staff);
   String delete(Integer staffID);
   String updateByPrimaryKeySelective(Staff staff);
   Integer selectCount(String tableName);
   Integer Suspension(Integer staffID);
   Users selectUsersByKey(Integer phone);
}
