package com.zyyu.ucp.controller;

import com.zyyu.ucp.ServerConfig;
import com.zyyu.ucp.UcpConfig;
import com.zyyu.ucp.annotation.CurrUser;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.utils.SysInfoUtil;
import com.zyyu.ucp.vo.LoginVo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.vo.SystemInfoVo;
import com.zyyu.ucp.vo.User1Vo;
import com.zyyu.ucp.vo.UserVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    UserService userService;
    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private UcpConfig ucpConfig;

    @PostMapping(value = "/home")
    public Result admin(@CurrUser String userId,@RequestBody LoginVo loginVO){
        //使用dozer进行对象转换
//        Mapper dozerMapper = new DozerBeanMapper();
//        User1Vo userVO = dozerMapper.map(loginVO, User1Vo.class);

        UserPo userPo = userService.getByUserId(Long.valueOf(userId));
        return success(userPo);
    }

    @GetMapping(value = "/sys_info")
    public Result getSysInfo(@CurrUser String userId){
        SystemInfoVo systemInfoVo = SysInfoUtil.property();
        systemInfoVo.setServerIP(serverConfig.getHost());
        systemInfoVo.setLocalPort(serverConfig.getServerPort());
        String  dd =ucpConfig.getDatasourceUrl();
        return success(systemInfoVo);
    }
}
