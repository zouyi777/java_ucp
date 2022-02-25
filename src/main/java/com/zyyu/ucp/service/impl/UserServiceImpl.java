package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.ServerConfig;
import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.enums.GenderEnum;
import com.zyyu.ucp.enums.AccountStateEnum;
import com.zyyu.ucp.model.po.UserPo;
import com.zyyu.ucp.mapper.UserMapper;
import com.zyyu.ucp.model.vo.SearchConditionBaseVo;
import com.zyyu.ucp.service.RoleService;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.utils.DateTimeUtil;
import com.zyyu.ucp.utils.FileHandleUtil;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import com.zyyu.ucp.model.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
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
    private RoleService roleService;

    @Autowired
    private ServerConfig serverConfig;

    @Override
    public UserPo loginIn(UserPo userPo) {
        UserPo uerPo = userMapper.login(userPo);
        uerPo.setAvatar(FileHandleUtil.getImageWholeUrl(serverConfig.getBaseUrl(),userPo.getAvatar()));
        return uerPo;
    }

    @Override
    public int add(UserPo userPo) {
        userPo.setId(UniqueKeyUtil.getUniqueKey());
        userPo.setState(AccountStateEnum.NORMAL);
        userPo.setCreateTime(DateTimeUtil.getCurDateTime());
        userPo.setUpdateTime(DateTimeUtil.getCurDateTime());
        userPo.setGender(GenderEnum.MAN);
        userPo.setRoleId(roleService.getByRoleCode("customer").getId());
        if(StringUtils.isEmpty(userPo.getAvatar())){
            userPo.setAvatar("default-head.png");
        }
        return userMapper.add(userPo);
    }

    @Override
    public UserPo getById(Long userId) {
        UserPo userPo = userMapper.getById(userId);
        userPo.setAvatar(FileHandleUtil.getImageWholeUrl(serverConfig.getBaseUrl(),userPo.getAvatar()));
        return userPo;
    }

    @Override
    public List<UserPo> getAll() {
        List<UserPo> list = userMapper.getAll();
        for(UserPo userPo:list){
            userPo.setAvatar(FileHandleUtil.getImageWholeUrl(serverConfig.getBaseUrl(),userPo.getAvatar()));
        }
        return list;
    }

    @Override
    public Integer getTotalCount() {
        return userMapper.getTotalCount();
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {
        List<UserVo> userVoList = new ArrayList<>();
        if(pageInfo ==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(getTotalCount());
        List<UserPo> userPoList = userMapper.getAllByPage(pageInfo);

        if(userPoList!=null && userPoList.size()>0){
            Mapper dozerMapper = new DozerBeanMapper();
            for(UserPo userPo:userPoList){
                UserVo userVo = dozerMapper.map(userPo, UserVo.class);
                userVo.setAvatar(FileHandleUtil.getImageWholeUrl(serverConfig.getBaseUrl(),userVo.getAvatar()));
                userVoList.add(userVo);
            }
        }
        pageInfo.setDataList(userVoList);
        return pageInfo;
    }

    @Override
    public PageInfo searchByCondition(SearchConditionBaseVo searchConditionVo) {
        PageInfo pageInfo = searchConditionVo.getPageInfo();
        Integer count = userMapper.searchByConditionCount(searchConditionVo);
        pageInfo.setTotalCount(count);

        List<UserPo> userPoList = userMapper.searchByCondition(searchConditionVo);
        List<UserVo> userVoList = new ArrayList<>();
        if(userPoList!=null && userPoList.size()>0){
            Mapper dozerMapper = new DozerBeanMapper();
            for(UserPo userPo:userPoList){
                UserVo userVo = dozerMapper.map(userPo, UserVo.class);
                userVo.setAvatar(FileHandleUtil.getImageWholeUrl(serverConfig.getBaseUrl(),userVo.getAvatar()));
                userVoList.add(userVo);
            }
        }
        pageInfo.setDataList(userVoList);
        return pageInfo;
    }

    @Override
    public Integer searchByConditionCount(SearchConditionBaseVo searchConditionVo) {
        return userMapper.searchByConditionCount(searchConditionVo);
    }

    @Override
    public int delete(UserPo userPo) {
        return userMapper.delete(userPo);
    }

    @Override
    public int update(UserPo userPo) {
        userPo.setUpdateTime(DateTimeUtil.getCurDateTime());
        return userMapper.update(userPo);
    }

    @Override
    public UserPo getByUserName(String userName) {
        UserPo userPo = userMapper.getByUserName(userName);
        return userPo;
    }

    @Override
    public UserPo getByMobilePhone(String mobilePhone) {
        UserPo userPo = userMapper.getByMobilePhone(mobilePhone);
        return userPo;
    }

    @Override
    public UserPo getByEmail(String email) {
        UserPo userPo = userMapper.getByEmail(email);
        return userPo;
    }
}
