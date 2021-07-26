package com.zyyu.ucp.mapper;

import com.zyyu.ucp.po.UserPo;

public interface UserMapper {

    UserPo login(String name, String password);

    void addUser(UserPo userPo);
}
