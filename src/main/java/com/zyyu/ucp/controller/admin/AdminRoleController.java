package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.Result;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/role")
public class AdminRoleController extends BaseController {

    @Autowired
    RoleService roleService;

    @PostMapping(value = "/list")
    public Result list(@RequestBody PageInfo pageInfo){
        pageInfo = roleService.getAllByPage(pageInfo);
        return success(pageInfo);
    }

}
