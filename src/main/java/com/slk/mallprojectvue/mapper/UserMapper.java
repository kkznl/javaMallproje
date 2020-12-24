package com.slk.mallprojectvue.mapper;

import com.slk.mallprojectvue.pojo.User;

import java.util.ArrayList;

public interface UserMapper {

    //分页查询用户列表
    public ArrayList<User> selectSomeUsersByPage(Integer sizeNow,Integer pageSize);

    //查询用户总数
    public Integer selectTotalUsers();
}
