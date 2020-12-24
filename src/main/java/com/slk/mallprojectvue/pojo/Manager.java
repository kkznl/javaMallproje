package com.slk.mallprojectvue.pojo;

import io.swagger.annotations.Api;
import lombok.Data;

@Data
@Api("管理员的实体类")
public class Manager {
    private Integer mgId;
    private String mgName;
    private String mgPwd;
    private Integer mgTime;
    private Integer roleId;
    private String mgMobile;
    private String mgEmail;
    private Integer mgState;
}
