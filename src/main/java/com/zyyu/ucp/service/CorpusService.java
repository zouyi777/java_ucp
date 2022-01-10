package com.zyyu.ucp.service;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.po.CorpusPo;
import com.zyyu.ucp.model.vo.CorpusVo;
import com.zyyu.ucp.model.vo.SearchConditionVo;


public interface CorpusService extends BaseService<CorpusPo>{

      CorpusVo getVoByContent(CorpusVo corpusVo);

      CorpusVo getVoByContentMD5(CorpusVo corpusVo);

      PageInfo searchCorpus(SearchConditionVo searchConditionVo);

      Integer searchCorpusCount(SearchConditionVo searchConditionVo);
}
