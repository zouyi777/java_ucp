package com.zyyu.ucp.service.impl;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.mapper.CorpusMapper;
import com.zyyu.ucp.po.CorpusPo;
import com.zyyu.ucp.service.CorpusService;
import com.zyyu.ucp.utils.DateTimeUtil;
import com.zyyu.ucp.utils.UniqueKeyUtil;
import com.zyyu.ucp.vo.CorpusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorpusServiceImpl implements CorpusService {

    @Autowired
    private CorpusMapper corpusMapper;

    @Override
    public int add(CorpusPo corpusPo) {
        corpusPo.setId(UniqueKeyUtil.getUniqueKey());
        corpusPo.setCreateTime(DateTimeUtil.getCurDateTime());
        corpusPo.setUpdateTime(DateTimeUtil.getCurDateTime());
        return corpusMapper.add(corpusPo);
    }

    @Override
    public int delete(CorpusPo corpusPo) {
        return corpusMapper.delete(corpusPo);
    }

    @Override
    public int update(CorpusPo corpusPo) {
        return corpusMapper.update(corpusPo);
    }

    @Override
    public CorpusPo getById(Long id) {
        return corpusMapper.getById(id);
    }

    @Override
    public List<CorpusPo> getAll() {
        return corpusMapper.getAll();
    }

    @Override
    public Integer getTotalCount() {
        return corpusMapper.getTotalCount();
    }

    @Override
    public PageInfo getAllByPage(PageInfo pageInfo) {
        if(pageInfo==null){
            pageInfo = new PageInfo();
        }
        pageInfo.setTotalCount(getTotalCount());
        List<CorpusVo> dataList = corpusMapper.getVoByPage(pageInfo);

        pageInfo.setDataList(dataList);
        return pageInfo;
    }
}
