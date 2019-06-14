package com.bj186.oa.service.impl;

import com.bj186.oa.mapper.UserMapper;
import com.bj186.oa.pojo.User;
import com.bj186.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User selectUserById2(Long id) {
        return userMapper.selectUserById2(id);
    }
}
