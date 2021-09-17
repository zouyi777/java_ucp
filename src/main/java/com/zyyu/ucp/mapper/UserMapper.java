package com.zyyu.ucp.mapper;

import com.zyyu.ucp.po.UserPo;

import java.util.List;

public interface UserMapper extends BaseMapper<UserPo>{

    UserPo login(UserPo userPo);

    List<UserPo> getAllByPage(Integer startIndex, Integer pageSize);

}
