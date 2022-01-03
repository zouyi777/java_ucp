package com.zyyu.ucp.mapper;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.po.CorpusPo;
import com.zyyu.ucp.vo.CorpusVo;

import java.util.List;

public interface CorpusMapper extends BaseMapper<CorpusPo>{

    List<CorpusVo> getVoByPage(PageInfo pageInfo);

    CorpusVo getVoByContent(CorpusVo corpusVo);

}
