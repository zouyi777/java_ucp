package com.zyyu.ucp.service;

import com.zyyu.ucp.po.UserPo;


public interface UserService extends BaseService<UserPo>{

    UserPo loginIn(UserPo userPo);

}
