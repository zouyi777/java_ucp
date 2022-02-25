package com.zyyu.ucp.mapper;

import com.zyyu.ucp.model.po.UserPo;
import com.zyyu.ucp.model.vo.UserVo;

public interface UserMapper extends BaseMapper<UserPo, UserVo>{

    UserPo login(UserPo userPo);

    UserPo getByUserName(String userName);

    UserPo getByMobilePhone(String mobilePhone);

    UserPo getByEmail(String email);

}
