package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.ServerConfig;
import com.zyyu.ucp.UcpConfig;
import com.zyyu.ucp.annotation.CurrUser;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.utils.SysInfoUtil;
import com.zyyu.ucp.vo.LoginVo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.vo.SystemInfoVo;
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
