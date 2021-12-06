package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.mapper.AdministratorMapper;
import com.zyyu.ucp.po.AdministratorPo;
import com.zyyu.ucp.service.AdministratorService;
import com.zyyu.ucp.vo.AdministratorVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public AdministratorPo adminLoginIn(AdministratorPo administratorPo) {
        return administratorMapper.adminLogin(administratorPo);
    }

    @Override
    public int add(AdministratorPo administratorPo) {
        return administratorMapper.add(administratorPo);
    }

    @Override
    public int delete(AdministratorPo administratorPo) {
        return administratorMapper.delete(administratorPo);
    }

    @Override
    public int update(AdministratorPo administratorPo) {
        return administratorMapper.update(administratorPo);
    }

    @Override
    public AdministratorPo getById(Long id) {
        return administratorMapper.getById(id);
    }

    @Override
    public List<AdministratorPo> getAll() {
        return administratorMapper.getAll();
    }

    @Override
    public Integer getTotalCount() {
        return administratorMapper.getTotalCount();
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {

        if(pageInfo==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(getTotalCount());
        List<AdministratorVo> administratorVoList = administratorMapper.getVoByPage(pageInfo);

        pageInfo.setDataList(administratorVoList);
        return pageInfo;
    }
}
