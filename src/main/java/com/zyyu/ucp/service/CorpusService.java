package com.zyyu.ucp.service;

import com.zyyu.ucp.model.po.CorpusPo;
import com.zyyu.ucp.model.vo.CorpusVo;


public interface CorpusService extends BaseService<CorpusPo>{

      CorpusVo getVoByContent(CorpusVo corpusVo);

      CorpusVo getVoByContentMD5(CorpusVo corpusVo);

}
