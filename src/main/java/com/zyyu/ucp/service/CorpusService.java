package com.zyyu.ucp.service;

import com.zyyu.ucp.po.CorpusPo;
import com.zyyu.ucp.vo.CorpusVo;


public interface CorpusService extends BaseService<CorpusPo>{

      CorpusVo getVoByContent(CorpusVo corpusVo);
}
