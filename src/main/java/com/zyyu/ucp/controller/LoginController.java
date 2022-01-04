package com.zyyu.ucp.controller;

import com.zyyu.ucp.model.po.RolePo;
import com.zyyu.ucp.model.po.UserPo;
import com.zyyu.ucp.service.RoleService;
import com.zyyu.ucp.model.vo.LoginVo;
import com.zyyu.ucp.model.Result;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.utils.JwtUtil;
import com.zyyu.ucp.service.UserService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController extends BaseController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginVo loginVO){
        Mapper dozerMapper = new DozerBeanMapper();
        UserPo userPO = userService.loginIn(dozerMapper.map(loginVO,UserPo.class));
        if(userPO !=null){
            RolePo rolePo = roleService.getById(userPO.getRoleId());
            return success(JwtUtil.getToken(String.valueOf(userPO.getId()),rolePo.getRoleCode()));
        }else {
            return fail(ResultEnum.ACCOUNT_NON_EXIST);
        }
    }


}
