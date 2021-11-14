package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.mapper.WorksMapper;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.po.WorksPo;
import com.zyyu.ucp.service.WorksService;
import com.zyyu.ucp.utils.DateTimeUtil;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import com.zyyu.ucp.vo.UserVo;
import com.zyyu.ucp.vo.WorksVo;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorksServiceImpl implements WorksService {

    @Autowired
    private WorksMapper worksMapper;

    @Override
    public int add(WorksPo worksPo) {
        worksPo.setId(UniqueKeyUtil.getUniqueKey());
        worksPo.setCreateTime(DateTimeUtil.getCurDateTime());
        worksPo.setUpdateTime(DateTimeUtil.getCurDateTime());
        if(StringUtils.isEmpty(worksPo.getQuote())){
            worksPo.setQuote("default-works.png");
        }
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
        List<WorksVo> dataList = worksMapper.getVoByPage(pageInfo);

        pageInfo.setDataList(dataList);
        return pageInfo;
    }
}
