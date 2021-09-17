package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.vo.LoginVo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.utils.JwtUtil;
import com.zyyu.ucp.service.UserService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminLoginController extends BaseController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginVo loginVO){
        Mapper dozerMapper = new DozerBeanMapper();
        UserPo userPO = userService.loginIn(dozerMapper.map(loginVO,UserPo.class));
        if(userPO !=null){
            return success(JwtUtil.getToken(String.valueOf(userPO.getId())));
        }else {
            return fail(ResultEnum.ACCOUNT_NON_EXIST);
        }
    }


}
