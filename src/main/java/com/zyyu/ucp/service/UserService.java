package com.zyyu.ucp.service;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.vo.LoginVo;


public interface UserService extends BaseService<UserPo>{

    UserPo loginIn(UserPo userPo);

    PageInfo getAllByPage(PageInfo pageInfo);

}
