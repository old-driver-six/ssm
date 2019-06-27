package com.bj186.oas.service.system;

import com.bj186.oas.entity.system.User;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.pojo.Users;

import java.util.List;

public interface UserService {

   Staff selectByPrimaryKey(Integer staffID);
   List<Staff> select(String filed, String value, Integer pageSize, Integer pageNum);
   List<Staff> selectByDep(String depName,String filed, String value,Integer pageSize, Integer pageNum);
   List<Staff> selectAll();
   String insert(User user);
   String update(User user);
   String delete(Integer staffID);
   String updateByPrimaryKeySelective(Staff staff);
   Integer selectCount(String tableName);

   /**
    * 停职
    * @param staffID
    * @return
    */
   Integer Suspension(Integer staffID);
   /**
    * 离职
    * @param staffID
    * @return
    */
   Integer Departure(Integer staffID);
   /**
    * 复职
    * @param staffID
    * @return
    */
   Integer Reinstatement(Integer staffID);
   Users selectUsersByKey(String phone);
}
