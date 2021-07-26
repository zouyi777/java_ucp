package com.zyyu.ucp.controller;

import com.zyyu.ucp.annotation.CurrUser;
import com.zyyu.ucp.vo.LoginVo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.vo.User1Vo;
import com.zyyu.ucp.vo.UserVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @PostMapping(value = "/home")
    public Result admin(@CurrUser String userId,@RequestBody LoginVo loginVO){
//        UserPO userPO = new UserPO();
//        userPO.setId(Integer.valueOf(userId).intValue());
//        userPO.setName(loginVO.getUsername());
//        userPO.setPassword(loginVO.getPassword());
//        userPO.setGender(loginVO.getGender());
        //使用dozer进行对象转换
        Mapper dozerMapper = new DozerBeanMapper();
        User1Vo userVO = dozerMapper.map(loginVO, User1Vo.class);
        return success(userVO);
    }

}
