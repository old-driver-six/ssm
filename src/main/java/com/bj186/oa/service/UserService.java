package com.bj186.oa.service;


import com.bj186.oa.pojo.User;

public interface UserService {
    void addUser(User user);
    User selectUserById2(Long id);
}
