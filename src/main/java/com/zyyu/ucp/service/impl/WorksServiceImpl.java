package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.ServerConfig;
import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.mapper.WorksMapper;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.po.WorksPo;
import com.zyyu.ucp.service.WorksService;
import com.zyyu.ucp.utils.DateTimeUtil;
import com.zyyu.ucp.utils.FilePathUtil;
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
    private ServerConfig serverConfig;

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
        WorksPo worksPo = worksMapper.getById(id);
        worksPo.setQuote(FilePathUtil.getImageWholePath(serverConfig.getHostPort(),worksPo.getQuote()));
        return worksPo;
    }

    @Override
    public List<WorksPo> getAll() {
        List<WorksPo> list = worksMapper.getAll();
        for(WorksPo worksPo:list){
            worksPo.setQuote(FilePathUtil.getImageWholePath(serverConfig.getHostPort(),worksPo.getQuote()));
        }
        return list;
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
        for(WorksVo worksVo:dataList){
            worksVo.setQuote(FilePathUtil.getImageWholePath(serverConfig.getHostPort(),worksVo.getQuote()));
        }
        pageInfo.setDataList(dataList);
        return pageInfo;
    }
}
