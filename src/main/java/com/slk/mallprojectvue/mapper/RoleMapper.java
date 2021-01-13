package com.slk.mallprojectvue.mapper;

import com.slk.mallprojectvue.pojo.Role;

import java.util.List;

public interface RoleMapper {

    //查询所有权限信息
    public List<Role> selectAllRoles();
}
