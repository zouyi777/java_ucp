package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.mapper.RightMapper;
import com.zyyu.ucp.po.RightPo;
import com.zyyu.ucp.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RightServiceImpl implements RightService {

    @Autowired
    private RightMapper rightMapper;


    @Override
    public int add(RightPo rightPo) {
        return rightMapper.add(rightPo);
    }

    @Override
    public int delete(RightPo rightPo) {
        return rightMapper.delete(rightPo);
    }

    @Override
    public int update(RightPo rightPo) {
        return rightMapper.update(rightPo);
    }

    @Override
    public RightPo getById(Long id) {
        return rightMapper.getById(id);
    }

    @Override
    public List<RightPo> getAll() {
        return rightMapper.getAll();
    }

    @Override
    public Integer getTotalCount() {
        return rightMapper.getTotalCount();
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {
        if(pageInfo==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(getTotalCount());
        List dataList = rightMapper.getAllByPage(pageInfo);
        pageInfo.setDataList(dataList);
        return pageInfo;
    }
}
