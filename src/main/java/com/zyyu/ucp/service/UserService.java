package com.zyyu.ucp.service;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.po.UserPo;


public interface UserService {

    UserPo loginIn(String name, String password);

    void addUser(UserPo userPo);

    UserPo getByUserId(Long userId);

    PageInfo getAllByPage(PageInfo pageInfo);

}
