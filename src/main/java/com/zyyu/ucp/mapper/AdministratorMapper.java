package com.zyyu.ucp.mapper;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.po.AdministratorPo;
import com.zyyu.ucp.model.vo.AdministratorVo;

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
