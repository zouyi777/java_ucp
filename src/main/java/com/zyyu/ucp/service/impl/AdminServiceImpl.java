package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.mapper.AdminMapper;
import com.zyyu.ucp.po.AdminPo;
import com.zyyu.ucp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public AdminPo adminLoginIn(AdminPo adminPo) {
        return adminMapper.adminLogin(adminPo);
    }

    @Override
    public int add(AdminPo adminPo) {
        return adminMapper.add(adminPo);
    }

    @Override
    public int delete(AdminPo adminPo) {
        return adminMapper.delete(adminPo);
    }

    @Override
    public int update(AdminPo adminPo) {
        return adminMapper.update(adminPo);
    }

    @Override
    public AdminPo getById(Long id) {
        return adminMapper.getById(id);
    }

    @Override
    public List<AdminPo> getAll() {
        return adminMapper.getAll();
    }

    @Override
    public Integer getTotalCount() {
        return adminMapper.getTotalCount();
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {
        if(pageInfo==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(getTotalCount());
        List dataList = adminMapper.getAllByPage(pageInfo);
        pageInfo.setDataList(dataList);
        return pageInfo;
    }
}
