package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.mapper.WorksMapper;
import com.zyyu.ucp.po.WorksPo;
import com.zyyu.ucp.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WorksServiceImpl implements WorksService {

    @Autowired
    private WorksMapper worksMapper;

    @Override
    public int add(WorksPo worksPo) {
        return worksMapper.add(worksPo);
    }

    @Override
    public int delete(WorksPo worksPo) {
        return worksMapper.delete(worksPo);
    }

    @Override
    public int update(WorksPo worksPo) {
        return worksMapper.update(worksPo);
    }

    @Override
    public WorksPo getById(Long id) {
        return worksMapper.getById(id);
    }

    @Override
    public List<WorksPo> getAll() {
        return worksMapper.getAll();
    }

    @Override
    public Integer getTotalCount() {
        return worksMapper.getTotalCount();
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {
        if(pageInfo==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(getTotalCount());
        List dataList = worksMapper.getAllByPage(pageInfo);
        pageInfo.setDataList(dataList);
        return pageInfo;
    }
}
