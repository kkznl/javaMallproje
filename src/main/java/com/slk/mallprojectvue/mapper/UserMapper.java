package com.slk.mallprojectvue.mapper;

import com.slk.mallprojectvue.pojo.User;

import java.util.ArrayList;

public interface UserMapper {

    //分页查询用户列表
    public ArrayList<User> selectSomeUsersByPage(Integer sizeNow,Integer pageSize);
    //查询用户总数
    public Integer selectTotalUsers();
    //分页查询模糊用户
    public ArrayList<User> selectUsersLikesSome(String query,Integer sizeNow,Integer pageSize);
    //查询模糊用户总数
    public Integer selectTotalUsersLikesSome(String query);
    //新增一个用户
    public Integer insertOneUser(User user);
    //根据id删除用户
    public Integer deleteOneUserById(Integer id);
    //根据用户名，搜索用户
    public User selectOneUserByName(String name );
}
