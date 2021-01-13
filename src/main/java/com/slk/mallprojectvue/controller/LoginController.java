package com.slk.mallprojectvue.controller;

import com.slk.mallprojectvue.pojo.Manager;
import com.slk.mallprojectvue.pojo.User;
import com.slk.mallprojectvue.service.ManagerService;
import com.slk.mallprojectvue.service.UserService;
import com.slk.mallprojectvue.utils.JWTutil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @Autowired
    private UserService userService;


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

    //分页获取用户信息
    @GetMapping("/users")
    @ApiOperation("分页获取用户信息")
    public Map getUsers(String query,Integer pagenum,Integer pagesize){
        //如果query是null，则正常翻页
        Map<String , Object> map = new HashMap<>();
        if("".equals(query)){
            //存放用户
            map.put("users",userService.getSomeUsersByPage(pagesize * (pagenum - 1),pagesize));
            map.put("totalpage",userService.getTotalUsers());
        }else {
            //模糊查询用户，先空着，等后面视频看了需求再写
            query = "%" + query + "%";
            map.put("users",userService.getSomeUsersLikeSome(query, pagesize * (pagenum - 1), pagesize));
            map.put("totalpage",userService.getUsersLikeTotal(query));
        }
        //添加记录总数、当前页、请求状态
        Map<String ,Object> meta = new HashMap<>();
        meta.put("msg","获取成功");
        meta.put("status",200);
        map.put("meta",meta);

        map.put("pagenum",pagenum);
        //如果不是null，就是模糊查询了
        return  map;
    }

    //添加一个用户信息
    @PostMapping("/addUser")
    @ApiOperation("新增一个用户的信息")
    public Map addUser(String userName,String password,String email,String mobile){
        Map<String,Object> map = new HashMap<>();
        User u = new User();
        u.setUserName(userName);
        u.setMobile(mobile);
        u.setType(1);
        u.setEmail(email);
        u.setCreatTime((new Date()).getTime());
        u.setStatus(true);
        u.setRoleName("");
        u.setPassword(password);
        u.setRoleId(42);   //42是默认权限id
        System.out.println(u);
        int flag = userService.addOneUser(u);
        if(flag > 0){
            map.put("status",200);
            map.put("msg","添加成功");
        }else {
            map.put("status",500);
            map.put("msg","添加失败");
        }
        return map;
    }

    //根据id删除一个用户
    @GetMapping("/deleteUser")
    @ApiOperation("根据id，删除一个用户")
    public Integer deleteUser(Integer id){
        return userService.dropOneUserById(id);
    }

    //更新用户
    @GetMapping("/updateUser")
    @ApiOperation("更新用户信息")
    public Integer updateUser(Integer id,String email,String mobile){
        return userService.setNewUserById(id, email, mobile);
    }

    //更新用户状态
    @GetMapping("/updateUserStatus")
    @ApiOperation("更新用户状态")
    public Integer updateUserStatus(Integer id,Boolean status){
        return userService.setNewUserStatusById(id, status);
    }

}
