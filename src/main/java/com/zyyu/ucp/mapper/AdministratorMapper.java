package com.zyyu.ucp.mapper;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.po.AdministratorPo;
import com.zyyu.ucp.vo.AdministratorVo;

import java.util.List;

public interface AdministratorMapper extends BaseMapper<AdministratorPo> {

    /**
     * 管理员登录
     * @return
     */
    AdministratorPo adminLogin(AdministratorPo administratorPo);

    /**
     * 分页查询返回Vo
     * @param pageInfo
     * @return
     */
    List<AdministratorVo> getVoByPage(PageInfo pageInfo);
}
