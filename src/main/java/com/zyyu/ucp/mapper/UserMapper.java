package com.zyyu.ucp.mapper;

import com.zyyu.ucp.po.UserPo;

public interface UserMapper extends BaseMapper<UserPo>{

    UserPo login(UserPo userPo);

    UserPo getByUserName(String userName);

    UserPo getByMobilePhone(String mobilePhone);

    UserPo getByEmail(String email);

}
