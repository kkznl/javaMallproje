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
        return userMapper.selectSomeUsersByPage(sizeNow, pageSize);
    }

    @Override
    public Integer getTotalUsers() {
        return userMapper.selectTotalUsers();
    }

    @Override
    public ArrayList<User> getSomeUsersLikeSome(String query, Integer sizeNow, Integer pageSize) {
        return userMapper.selectUsersLikesSome(query, sizeNow, pageSize);
    }

    @Override
    public Integer getUsersLikeTotal(String query) {
        return userMapper.selectTotalUsersLikesSome(query);
    }


    @Override
    public Integer addOneUser(User user) {
        return userMapper.insertOneUser(user);
    }

    @Override
    public Integer dropOneUserById(Integer id) {
        return userMapper.deleteOneUserById(id);
    }

    @Override
    public User getOneUserByName(String name) {
        return userMapper.selectOneUserByName(name);
    }

    @Override
    public Integer setNewUserById(Integer id, String email, String mobile) {
        return userMapper.updateOneUserById(id, email, mobile);
    }
    @Override
    public Integer setNewUserStatusById(Integer id, Boolean status) {
        return userMapper.updateOneUserStatusById(id, status);
    }

    @Override
    public Integer setNewUserRoleById(Integer id, Integer roleId) {
        return userMapper.updateOneUserRoleById(id, roleId);
    }
}
