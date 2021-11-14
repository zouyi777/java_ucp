package com.zyyu.ucp.mapper;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.po.WorksPo;
import com.zyyu.ucp.vo.WorksVo;

import java.util.List;

public interface WorksMapper extends BaseMapper<WorksPo>{

    List<WorksVo> getVoByPage(PageInfo pageInfo);

}
