package com.slk.mallprojectvue.service.impl;

import com.slk.mallprojectvue.mapper.ManagerMapper;
import com.slk.mallprojectvue.pojo.Manager;
import com.slk.mallprojectvue.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Manager getOneManagerByMobile( String mgName ,String mgPwd) {
        return managerMapper.selectOneManagerByMobile(mgName,mgPwd);
    }
}
