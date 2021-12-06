package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/right")
public class AdminRightController extends BaseController {

    @Autowired
    RightService rightService;

    @PostMapping(value = "/list")
    public Result list(@RequestBody PageInfo pageInfo){
        pageInfo = rightService.getAllByPage(pageInfo);
        return success(pageInfo);
    }

}
