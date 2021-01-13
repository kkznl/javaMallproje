package com.slk.mallprojectvue.service;

import com.slk.mallprojectvue.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public interface UserService {


    //分页查询用户
    public ArrayList<User> getSomeUsersByPage(Integer sizeNow, Integer pageSize);

    //查询用户总数
    public Integer getTotalUsers();

    //模糊查询用户
    public ArrayList<User> getSomeUsersLikeSome(String query,Integer sizeNow, Integer pageSize);

    //模糊查询用户总数
    public Integer getUsersLikeTotal(String query);

    //增加用户
    public Integer addOneUser(User user);

    //删除用户
    public Integer dropOneUserById(Integer id);

    //用户名搜索用户
    public User getOneUserByName(String name);

    //更新用户信息
    public Integer setNewUserById(Integer id,String email,String mobile);

    //更新用户状态
    public Integer setNewUserStatusById(Integer id, Boolean status);

    //修改用户权限
    public Integer setNewUserRoleById(Integer id,Integer roleId);
}
