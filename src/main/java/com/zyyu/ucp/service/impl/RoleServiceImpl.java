package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.mapper.RoleMapper;
import com.zyyu.ucp.po.RolePo;
import com.zyyu.ucp.service.RoleService;
import com.zyyu.ucp.utils.DateTimeUtil;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int add(RolePo rolePo) {
        rolePo.setId(UniqueKeyUtil.getUniqueKey());
        rolePo.setRightId(UniqueKeyUtil.getUniqueKey());
        rolePo.setCreateTime(DateTimeUtil.getCurDateTime());
        rolePo.setUpdateTime(DateTimeUtil.getCurDateTime());
        return roleMapper.add(rolePo);
    }

    @Override
    public RolePo getById(Long id) {
        return roleMapper.getById(id);
    }

    @Override
    public Integer getTotalCount() {
        return roleMapper.getTotalCount();
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {
        if(pageInfo ==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(getTotalCount());
        pageInfo.setDataList(roleMapper.getAllByPage(pageInfo));
        return pageInfo;
    }

    @Override
    public int delete(RolePo rolePo) {
        return roleMapper.delete(rolePo);
    }

    @Override
    public int update(RolePo rolePo) {
        return roleMapper.update(rolePo);
    }

    @Override
    public List<RolePo> getAll() {
        return roleMapper.getAll();
    }

    @Override
    public RolePo getByRoleCode(String roleCode) {
        return roleMapper.getByRoleCode(roleCode);
    }
}
