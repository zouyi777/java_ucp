package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.enums.GenderEnum;
import com.zyyu.ucp.enums.UserStateEnum;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.mapper.UserMapper;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.utils.DateTimeUtil;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserPo loginIn(String name, String password) {

        return userMapper.login(name,password);
    }

    @Override
    public int addUser(UserPo userPo) {
        userPo.setUserId(UniqueKeyUtil.getUniqueKey());
        userPo.setState(UserStateEnum.NORMAL);
        userPo.setCreateTime(DateTimeUtil.getCurDateTime());
        userPo.setUpdateTime(DateTimeUtil.getCurDateTime());
        userPo.setGender(GenderEnum.MAN);
        return userMapper.addUser(userPo);
    }

    @Override
    public UserPo getByUserId(Long userId) {
        return userMapper.getByUserId(userId);
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {
        if(pageInfo ==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(userMapper.getTotalCount());
        pageInfo.setDataList(userMapper.getAllByPage(pageInfo.getStartIndex(),pageInfo.getPageSize()));
        return pageInfo;
    }

    @Override
    public int deleteUser(Long userId) {
        UserPo userPo =new UserPo();
        userPo.setUserId(userId);
        return userMapper.deleteUser(userPo);
    }

    @Override
    public int updateUser(UserPo userPo) {
        return userMapper.updateUser(userPo);
    }
}
