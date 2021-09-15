package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.enums.GenderEnum;
import com.zyyu.ucp.enums.UserStateEnum;
import com.zyyu.ucp.mapper.RoleMapper;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.mapper.UserMapper;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.utils.DateTimeUtil;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import com.zyyu.ucp.vo.UserVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserPo loginIn(String name, String password) {

        return userMapper.login(name,password);
    }

    @Override
    public int addUser(UserPo userPo) {
        userPo.setId(UniqueKeyUtil.getUniqueKey());
        userPo.setState(UserStateEnum.NORMAL);
        userPo.setCreateTime(DateTimeUtil.getCurDateTime());
        userPo.setUpdateTime(DateTimeUtil.getCurDateTime());
        userPo.setGender(GenderEnum.MAN);
        userPo.setRoleId(roleMapper.getByRoleCode("customer").getId());
        return userMapper.addUser(userPo);
    }

    @Override
    public UserPo getByUserId(Long userId) {
        return userMapper.getByUserId(userId);
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {
        List userVoList = new ArrayList<>();
        if(pageInfo ==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(userMapper.getTotalCount());
        List<UserPo> userPoList = userMapper.getAllByPage(pageInfo.getStartIndex(),pageInfo.getPageSize());
        if(userPoList!=null && userPoList.size()>0){
            Mapper dozerMapper = new DozerBeanMapper();
            for(UserPo UserPo:userPoList){
                userVoList.add(dozerMapper.map(UserPo, UserVo.class));
            }
        }
        pageInfo.setDataList(userVoList);
        return pageInfo;
    }

    @Override
    public int deleteUser(Long userId) {
        UserPo userPo =new UserPo();
        userPo.setId(userId);
        return userMapper.deleteUser(userPo);
    }

    @Override
    public int updateUser(UserPo userPo) {
        return userMapper.updateUser(userPo);
    }
}
