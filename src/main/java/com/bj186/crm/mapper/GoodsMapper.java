package com.bj186.crm.mapper;

import com.bj186.crm.pojo.User;

import java.util.List;

public interface GoodsMapper {
    User selectUserById(Long id);
    User selectUserById2(Long id);
    List<User> selectAll();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
