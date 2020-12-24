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
    private String creatTime;
    private Integer status;
    private String roleName;

}
