package com.zyyu.ucp.service;

import com.zyyu.ucp.model.po.RolePo;


public interface RoleService  extends BaseService<RolePo>{

    RolePo getByRoleCode(String roleCode);
}
