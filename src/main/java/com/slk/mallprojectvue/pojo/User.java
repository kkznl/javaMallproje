package com.slk.mallprojectvue.pojo;


import io.swagger.annotations.Api;
import lombok.Data;

@Data
@Api("用户的实体类")
public class User {

    private Integer id;
    private String userName;
    private String mobile;
    private Integer type;
    private String email;
    private Long creatTime;
    private Boolean status;
    private String roleName;
    private String password;
    private Integer roleId;

}
