package com.zyyu.ucp.service;

import com.zyyu.ucp.po.RolePo;
import java.util.List;


public interface RoleService {

    int add(RolePo rolePo);

    RolePo getById(Long id);

    Integer getTotalCount();

    int delete(RolePo rolePo);

    int update(RolePo rolePo);

    List<RolePo> getAll();

    RolePo getByRoleCode(String roleCode);
}
