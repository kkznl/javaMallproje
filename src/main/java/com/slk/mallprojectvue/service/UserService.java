package com.slk.mallprojectvue.service;

import com.slk.mallprojectvue.pojo.User;

import java.util.ArrayList;

public interface UserService {


    //分页查询用户
    public ArrayList<User> getSomeUsersByPage(Integer sizeNow, Integer pageSize);

    //查询用户总数
    public Integer getTotalUsers();
}
