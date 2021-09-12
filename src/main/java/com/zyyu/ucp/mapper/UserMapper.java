package com.zyyu.ucp.mapper;

import com.zyyu.ucp.po.UserPo;

import java.util.List;

public interface UserMapper {

    UserPo login(String name, String password);

    int addUser(UserPo userPo);

    UserPo getByUserId(Long userId);

    List<UserPo> getAllByPage(Integer startIndex, Integer pageSize);

    Integer getTotalCount();

    int deleteUser(UserPo userPo);

    int updateUser(UserPo userPo);
}
