package com.zyyu.ucp.controller;

import com.zyyu.ucp.annotation.CurrUser;
import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/list")
    public Result userList(@CurrUser String userId,@RequestBody PageInfo pageInfo){
        pageInfo = userService.getAllByPage(pageInfo);
        return success(pageInfo);
    }

    @GetMapping(value = "/detail")
    public Result userDetail(@CurrUser String userId){
        UserPo userPo = userService.getByUserId(Long.valueOf(userId));
        return success(userPo);
    }

}
