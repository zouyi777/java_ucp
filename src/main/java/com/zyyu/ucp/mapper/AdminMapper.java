package com.zyyu.ucp.mapper;

import com.zyyu.ucp.po.AdminPo;

public interface AdminMapper extends BaseMapper<AdminPo> {

    /**
     * 管理员登录
     * @return
     */
    AdminPo adminLogin(AdminPo adminPo);
}
