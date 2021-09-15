package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.annotation.CurrUser;
import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.vo.LoginVo;
import com.zyyu.ucp.vo.UserVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
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
    public Result userDetail(@RequestParam String userId){
        UserPo userPo = userService.getByUserId(Long.valueOf(userId));
        return success(userPo);
    }

    @GetMapping(value = "/delete")
    public Result deleteUser(@RequestParam String userId){
        int result = userService.deleteUser(Long.valueOf(userId));
        if(result==1){
            return success();
        }
        return fail("删除失败");
    }

    @PostMapping(value = "/update")
    public Result updateUser(@CurrUser String userId, @RequestBody UserVo userVo){
        Mapper dozerMapper = new DozerBeanMapper();
        UserPo userPo = dozerMapper.map(userVo,UserPo.class);
        int result = userService.updateUser(userPo);
        if(result==1){
            return success();
        }
        return fail("修改失败");
    }

    @PostMapping(value = "/add")
    public Result userAdd(@RequestBody UserVo userVo){
        Mapper dozerMapper = new DozerBeanMapper();
        UserPo userPo = dozerMapper.map(userVo,UserPo.class);
        int result = userService.addUser(userPo);
        if(result==1){
            return success();
        }
        return fail("新增失败");
    }

}
