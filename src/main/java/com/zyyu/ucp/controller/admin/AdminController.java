package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.ServerConfig;
import com.zyyu.ucp.UcpConfig;
import com.zyyu.ucp.annotation.CurrUser;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.po.AdminPo;
import com.zyyu.ucp.po.RolePo;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.AdminService;
import com.zyyu.ucp.service.RoleService;
import com.zyyu.ucp.utils.JwtUtil;
import com.zyyu.ucp.utils.SysInfoUtil;
import com.zyyu.ucp.vo.AdminLoginVo;
import com.zyyu.ucp.vo.LoginVo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.vo.SystemInfoVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private UcpConfig ucpConfig;
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/home")
    public Result admin(@CurrUser String userId,@RequestBody LoginVo loginVO){
        AdminPo adminPo = adminService.getById(Long.valueOf(userId));
        return success(adminPo);
    }

    @GetMapping(value = "/sys_info")
    public Result getSysInfo(@CurrUser String userId){
        SystemInfoVo systemInfoVo = SysInfoUtil.property();
        systemInfoVo.setServerIP(serverConfig.getHost());
        systemInfoVo.setLocalPort(serverConfig.getServerPort());
        String  dd =ucpConfig.getDatasourceUrl();
        return success(systemInfoVo);
    }

    @PostMapping(value = "/login")
    public Result login(@RequestBody AdminLoginVo adminLoginVo){
        Mapper dozerMapper = new DozerBeanMapper();
        AdminPo adminPo = adminService.adminLoginIn(dozerMapper.map(adminLoginVo,AdminPo.class));
        if(adminPo !=null){
            RolePo rolePo = roleService.getById(adminPo.getRoleId());
            return success(JwtUtil.getToken(String.valueOf(adminPo.getId()),rolePo.getRoleCode()));
        }else {
            return fail(ResultEnum.ACCOUNT_NON_EXIST);
        }
    }
}
