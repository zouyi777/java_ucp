package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.enums.UserStateEnum;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.mapper.UserMapper;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.utils.DateTimeUtil;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserPo loginIn(String name, String password) {

        return userMapper.login(name,password);
    }

    @Override
    public void addUser(UserPo userPo) {
        userPo.setUserId(UniqueKeyUtil.getUniqueKey());
        userPo.setState(UserStateEnum.NORMAL);
        userPo.setCreateTime(DateTimeUtil.getCurDateTime());
        userPo.setUpdateTime(DateTimeUtil.getCurDateTime());
        userMapper.addUser(userPo);
    }
}
