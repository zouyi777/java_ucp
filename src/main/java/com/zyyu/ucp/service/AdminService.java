package com.zyyu.ucp.service;

import com.zyyu.ucp.po.AdminPo;


public interface AdminService extends BaseService<AdminPo>{

    AdminPo adminLoginIn(AdminPo adminPo);

}
