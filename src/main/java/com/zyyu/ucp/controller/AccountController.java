package com.zyyu.ucp.controller;

import com.zyyu.ucp.annotation.CurrUser;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/home")
    public Result login(@CurrUser String userId){
        UserPo userPo = userService.getById(Long.valueOf(userId));
        return success(userPo);
    }

}
