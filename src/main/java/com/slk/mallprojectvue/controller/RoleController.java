package com.slk.mallprojectvue.controller;


import com.slk.mallprojectvue.pojo.Role;
import com.slk.mallprojectvue.service.RoleService;
import com.slk.mallprojectvue.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/role")
@Api("权限操作")
public class RoleController {

    @Autowired
    private RoleService service;
    @Autowired
    private UserService userService;

    //用户界面获取权限信息
    @ApiOperation("用户界面获取权限信息")
    @RequestMapping("/allRoles")
    public List<Role> allRoles(){
        return service.getAllRoles();
    }

    //修改用户权限
    @ApiOperation("修改用户权限")
        @RequestMapping("/updateRole")
    public Integer updateRole(Integer id,Integer roleId){
        return userService.setNewUserRoleById(id, roleId);
    }

}
