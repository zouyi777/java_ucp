package com.zyyu.ucp.controller;

import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.vo.LoginVo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.utils.JwtUtil;
import com.zyyu.ucp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController extends BaseController{

    //将Service注入Web层
    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginVo loginVO){
        UserPo userPO = userService.loginIn(loginVO.getUsername(), loginVO.getPassword());
        if(userPO !=null){
            return success(JwtUtil.getToken(String.valueOf(userPO.getUserId())));
        }else {
            return fail(ResultEnum.ACCOUNT_NON_EXIST);
        }
    }


}
