package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.ServerConfig;
import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.mapper.WorksMapper;
import com.zyyu.ucp.model.po.WorksPo;
import com.zyyu.ucp.model.vo.SearchConditionBaseVo;
import com.zyyu.ucp.service.WorksService;
import com.zyyu.ucp.utils.DateTimeUtil;
import com.zyyu.ucp.utils.FileHandleUtil;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import com.zyyu.ucp.model.vo.WorksVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        worksPo.setQuote(FileHandleUtil.getImageWholeUrl(serverConfig.getBaseUrl(),worksPo.getQuote()));
        return worksPo;
    }

    @Override
    public List<WorksPo> getAll() {
        List<WorksPo> list = worksMapper.getAll();
        for(WorksPo worksPo:list){
            worksPo.setQuote(FileHandleUtil.getImageWholeUrl(serverConfig.getBaseUrl(),worksPo.getQuote()));
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
            worksVo.setQuote(FileHandleUtil.getImageWholeUrl(serverConfig.getBaseUrl(),worksVo.getQuote()));
        }
        pageInfo.setDataList(dataList);
        return pageInfo;
    }

    @Override
    public PageInfo searchByCondition(SearchConditionBaseVo searchConditionVo) {
        return null;
    }

    @Override
    public Integer searchByConditionCount(SearchConditionBaseVo searchConditionVo) {
        return null;
    }
}
