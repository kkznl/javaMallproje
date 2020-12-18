package com.slk.mallprojectvue.controller;

import com.slk.mallprojectvue.pojo.Manager;
import com.slk.mallprojectvue.service.ManagerService;
import com.slk.mallprojectvue.utils.JWTutil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
@RequestMapping("/user")
@Api("管理员操作")
public class LoginController {
    @Autowired
    private ManagerService managerService;


    @PostMapping("/login")
    @ApiOperation("管理员登陆")
    public ConcurrentHashMap userLogin(String mgName , String mgPwd){
        ConcurrentHashMap<String ,Object> msg = new ConcurrentHashMap();
        System.out.println(mgName + mgPwd);
        Manager m = managerService.getOneManagerByMobile(mgName,mgPwd);
        System.out.println(m);

        if(m == null){
            //报错，并且返回
            msg.put("status",500);

        }else {
            msg.put("status",200);
            msg.put("data",m);
            //生成jwt
            Map<String,Object> claims = new HashMap();
            claims.put("manager",m);
            String jwt = JWTutil.creatJWT(claims,"manager",15*60*1000);
            msg.put("token",jwt);
        }
        return msg;
    }

    @GetMapping("/register")
    public String register(){
        return "ssss";
    }
}
