package com.zyyu.ucp.controller;

import com.zyyu.ucp.annotation.CurrAccount;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/home")
    public Result login(@CurrAccount String userId){
        UserPo userPo = userService.getById(Long.valueOf(userId));
        return success(userPo);
    }

}
