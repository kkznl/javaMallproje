package com.slk.mallprojectvue.service.impl;

import com.slk.mallprojectvue.mapper.UserMapper;
import com.slk.mallprojectvue.pojo.User;
import com.slk.mallprojectvue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //分页获取用户
    @Override
    public ArrayList<User> getSomeUsersByPage(Integer sizeNow, Integer pageSize) {
        return userMapper.selectSomeUsersByPage(sizeNow,pageSize );
    }

    @Override
    public Integer getTotalUsers() {
        return userMapper.selectTotalUsers();
    }
}
