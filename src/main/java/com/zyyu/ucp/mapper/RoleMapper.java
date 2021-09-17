package com.zyyu.ucp.mapper;

import com.zyyu.ucp.po.RolePo;

public interface RoleMapper extends BaseMapper<RolePo> {

    /**
     * 根据roleCode获取角色
     * @param roleCode
     * @return
     */
    RolePo getByRoleCode(String roleCode);
}
