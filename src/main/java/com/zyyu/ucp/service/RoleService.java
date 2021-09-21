package com.zyyu.ucp.service;

import com.zyyu.ucp.po.RolePo;
import java.util.List;


public interface RoleService  extends BaseService<RolePo>{

    RolePo getByRoleCode(String roleCode);
}
