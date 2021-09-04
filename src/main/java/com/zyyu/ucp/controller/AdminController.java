package com.zyyu.ucp.controller;

import com.zyyu.ucp.annotation.CurrUser;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.vo.LoginVo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.vo.User1Vo;
import com.zyyu.ucp.vo.UserVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/home")
    public Result admin(@CurrUser String userId,@RequestBody LoginVo loginVO){
        //使用dozer进行对象转换
//        Mapper dozerMapper = new DozerBeanMapper();
//        User1Vo userVO = dozerMapper.map(loginVO, User1Vo.class);

        UserPo userPo = userService.getByUserId(Long.valueOf(userId));
        return success(userPo);
    }

}
