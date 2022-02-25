package com.zyyu.ucp.mapper;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.po.RolePo;
import com.zyyu.ucp.model.vo.RoleVo;

import java.util.List;

public interface RoleMapper extends BaseMapper<RolePo,RoleVo> {

    /**
     * 根据roleCode获取角色
     * @param roleCode
     * @return
     */
    RolePo getByRoleCode(String roleCode);


    /**
     * 分页查询返回Vo
     * @param pageInfo
     * @return
     */
    List<RoleVo> getVoByPage(PageInfo pageInfo);
}
