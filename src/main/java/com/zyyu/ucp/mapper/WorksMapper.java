package com.zyyu.ucp.mapper;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.po.WorksPo;
import com.zyyu.ucp.model.vo.WorksVo;

import java.util.List;

public interface WorksMapper extends BaseMapper<WorksPo,WorksVo>{

    List<WorksVo> getVoByPage(PageInfo pageInfo);

}
