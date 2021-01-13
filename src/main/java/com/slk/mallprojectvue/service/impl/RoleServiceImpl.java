package com.slk.mallprojectvue.service.impl;

import com.slk.mallprojectvue.mapper.RoleMapper;
import com.slk.mallprojectvue.pojo.Role;
import com.slk.mallprojectvue.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.selectAllRoles();
    }
}
