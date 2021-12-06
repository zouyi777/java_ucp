package com.zyyu.ucp.mapper;

import com.zyyu.ucp.po.AdministratorPo;

public interface AdministratorMapper extends BaseMapper<AdministratorPo> {

    /**
     * 管理员登录
     * @return
     */
    AdministratorPo adminLogin(AdministratorPo administratorPo);
}
