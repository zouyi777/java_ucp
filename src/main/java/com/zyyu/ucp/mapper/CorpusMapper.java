package com.zyyu.ucp.mapper;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.po.CorpusPo;
import com.zyyu.ucp.model.vo.CorpusVo;

import java.util.List;

public interface CorpusMapper extends BaseMapper<CorpusPo>{

    List<CorpusVo> getVoByPage(PageInfo pageInfo);

    CorpusVo getVoByContent(CorpusVo corpusVo);

}
