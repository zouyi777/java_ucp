package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.annotation.CurrAccount;
import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
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
    public Result userList(@CurrAccount String userId, @RequestBody PageInfo pageInfo){
        pageInfo = userService.getAllByPage(pageInfo);
        return success(pageInfo);
    }

    @GetMapping(value = "/detail")
    public Result userDetail(@RequestParam String userId){
        UserPo userPo = userService.getById(Long.valueOf(userId));
        return success(userPo);
    }

    @GetMapping(value = "/delete")
    public Result deleteUser(@RequestParam String userId){
        UserPo userPo = new UserPo();
        userPo.setId(Long.valueOf(userId));
        int result = userService.delete(userPo);
        if(result==1){
            return success();
        }
        return fail("删除失败");
    }

    @PostMapping(value = "/update")
    public Result updateUser(@CurrAccount String userId, @RequestBody UserVo userVo){
        Mapper dozerMapper = new DozerBeanMapper();
        UserPo userPo = dozerMapper.map(userVo,UserPo.class);
        int result = userService.update(userPo);
        if(result==1){
            return success();
        }
        return fail("修改失败");
    }

    @PostMapping(value = "/add")
    public Result addUser(@RequestBody UserVo userVo){
        Mapper dozerMapper = new DozerBeanMapper();
        UserPo userPo = dozerMapper.map(userVo,UserPo.class);
        if(userService.getByEmail(userPo.getEmail())!=null){
            return fail("邮箱已存在");
        }
        if(userService.getByMobilePhone(userPo.getMobilePhone())!=null){
            return fail("手机号已存在");
        }
        if(userService.getByUserName(userPo.getUserName())!=null){
            return fail("用户名已存在");
        }
        int result = userService.add(userPo);
        if(result==1){
            return success();
        }
        return fail("新增失败");
    }

    @GetMapping(value = "/hasEmail")
    public Result hasEmail(@RequestParam String email){
        if(StringUtils.isNotEmpty(email)){
            UserPo userPo = userService.getByEmail(email);
            if(userPo==null){
                return success(false);
            }
            return success(true);
        }
        return fail(ResultEnum.PARAM_BLANK);
    }

    @GetMapping(value = "/hasMobilePhone")
    public Result hasMobilePhone(@RequestParam String mobilePhone){
        if(StringUtils.isNotEmpty(mobilePhone)){
            UserPo userPo = userService.getByMobilePhone(mobilePhone);
            if(userPo==null){
                return success(false);
            }
            return success(true);
        }
        return fail(ResultEnum.PARAM_BLANK);
    }

    @GetMapping(value = "/hasUserName")
    public Result hasUserName(@RequestParam String userName){
        if(StringUtils.isNotEmpty(userName)){
            UserPo userPo = userService.getByUserName(userName);
            if(userPo==null){
                return success(false);
            }
            return success(true);
        }
        return fail(ResultEnum.PARAM_BLANK);
    }

}
