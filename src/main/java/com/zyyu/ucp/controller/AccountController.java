package com.zyyu.ucp.controller;

import com.zyyu.ucp.annotation.CurrAccount;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.vo.UserVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/info")
    public Result info(@CurrAccount String userId){
        UserPo userPo = userService.getById(Long.valueOf(userId));
        Mapper dozMapper = new DozerBeanMapper();
        UserVo userVo = dozMapper.map(userPo,UserVo.class);
        return success(userVo);
    }
}
