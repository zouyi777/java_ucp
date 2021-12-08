package com.zyyu.ucp.controller;

import com.zyyu.ucp.annotation.CurrAccount;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.controller.admin.LogTestController;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.AccountService;
import com.zyyu.ucp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account1")
public class AccountController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    UserService userService;
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/home")
    public Result login(@CurrAccount String userId){
        UserPo userPo = userService.getById(Long.valueOf(userId));
        return success(userPo);
    }

    @RequestMapping("/transfer")
    public String test() {
        try {
            // andy 给lucy转账50元
            accountService.transfer(1, 2, 50);
            return "transfer success";
        } catch (Exception e) {
            logger.error("",e);
            return "transfer fail";
        }
    }
}
