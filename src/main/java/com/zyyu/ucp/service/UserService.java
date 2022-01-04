package com.zyyu.ucp.service;

import com.zyyu.ucp.model.po.UserPo;


public interface UserService extends BaseService<UserPo>{

    UserPo loginIn(UserPo userPo);

    UserPo getByUserName(String userName);

    UserPo getByMobilePhone(String mobilePhone);

    UserPo getByEmail(String email);

}
