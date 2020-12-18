package com.slk.mallprojectvue.mapper;

import com.slk.mallprojectvue.pojo.Manager;

public interface ManagerMapper {

    Manager selectOneManagerByMobile(String mgName,String mgPwd);

}
