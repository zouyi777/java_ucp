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
import com.zyyu.ucp.vo.LoginVo;
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
    public UserPo loginIn(UserPo userPo) {

        return userMapper.login(userPo);
    }

    @Override
    public int add(UserPo userPo) {
        userPo.setId(UniqueKeyUtil.getUniqueKey());
        userPo.setState(UserStateEnum.NORMAL);
        userPo.setCreateTime(DateTimeUtil.getCurDateTime());
        userPo.setUpdateTime(DateTimeUtil.getCurDateTime());
        userPo.setGender(GenderEnum.MAN);
        userPo.setRoleId(roleMapper.getByRoleCode("customer").getId());
        return userMapper.add(userPo);
    }

    @Override
    public UserPo getById(Long userId) {
        return userMapper.getById(userId);
    }

    @Override
    public List<UserPo> getAll() {
        return userMapper.getAll();
    }

    @Override
    public Integer getTotalCount() {
        return userMapper.getTotalCount();
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {
        List userVoList = new ArrayList<>();
        if(pageInfo ==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(getTotalCount());
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
    public int delete(UserPo userPo) {
        return userMapper.delete(userPo);
    }

    @Override
    public int update(UserPo userPo) {
        return userMapper.update(userPo);
    }
}
