package com.zyyu.ucp.mapper;

import com.zyyu.ucp.po.UserPo;

import java.util.List;

public interface UserMapper {

    UserPo login(String name, String password);

    void addUser(UserPo userPo);

    UserPo getByUserId(Long userId);

    List<UserPo> getAllByPage(Integer startIndex, Integer pageSize);

    Integer getTotalCount();
}
