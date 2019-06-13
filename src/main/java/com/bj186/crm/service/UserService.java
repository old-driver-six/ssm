package com.bj186.crm.service;


import com.bj186.crm.pojo.User;

public interface UserService {
    void addUser(User user);
    User selectUserById2(Long id);
}
