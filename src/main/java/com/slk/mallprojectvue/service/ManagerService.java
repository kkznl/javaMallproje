package com.slk.mallprojectvue.service;

import com.slk.mallprojectvue.pojo.Manager;

public interface ManagerService {

    Manager getOneManagerByMobile(String mgName ,String mgPwd);
}
