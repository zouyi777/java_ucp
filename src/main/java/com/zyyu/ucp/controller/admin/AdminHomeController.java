package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.ServerConfig;
import com.zyyu.ucp.UcpConfig;
import com.zyyu.ucp.annotation.CurrAccount;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.po.AdministratorPo;
import com.zyyu.ucp.po.RolePo;
import com.zyyu.ucp.service.AdministratorService;
import com.zyyu.ucp.service.RoleService;
import com.zyyu.ucp.service.UserService;
import com.zyyu.ucp.utils.FileHandleUtil;
import com.zyyu.ucp.utils.JwtUtil;
import com.zyyu.ucp.utils.SysInfoUtil;
import com.zyyu.ucp.vo.AdminLoginVo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.vo.AdministratorVo;
import com.zyyu.ucp.vo.SystemInfoVo;
import com.zyyu.ucp.vo.TopCardVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminHomeController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(AdminHomeController.class);
    @Autowired
    private AdministratorService adminService;
    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private UcpConfig ucpConfig;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/home")
    public Result admin(@CurrAccount String adminId){
        AdministratorPo administratorPo = adminService.getById(Long.valueOf(adminId));
        return success(administratorPo);
    }

    @GetMapping(value = "/member_show")
    public Result memberShow(@CurrAccount String adminId){
        AdministratorPo administratorPo = adminService.getById(Long.valueOf(adminId));
        Mapper dozerMapper = new DozerBeanMapper();
        AdministratorVo adminVo = dozerMapper.map(administratorPo, AdministratorVo.class);
        return success(adminVo);
    }

    @GetMapping(value = "/dashboard")
    public Result dashboard(){
        Map<String,Object> map = new HashMap();
        //顶部统计卡片
        TopCardVo topCardVo = new TopCardVo();
        topCardVo.setUserCount(userService.getTotalCount());
        map.put("topCardVo",topCardVo);;

        return success(map);
    }


    @PostMapping(value = "/login")
    public Result login(@RequestBody AdminLoginVo adminLoginVo){
        Mapper dozerMapper = new DozerBeanMapper();
        AdministratorPo administratorPo = adminService.adminLoginIn(dozerMapper.map(adminLoginVo, AdministratorPo.class));
        if(administratorPo !=null){
            logger.info("登录成功");
            RolePo rolePo = roleService.getById(administratorPo.getRoleId());
            return success(JwtUtil.getToken(String.valueOf(administratorPo.getId()),rolePo.getRoleCode()));
        }else {
            return fail(ResultEnum.ACCOUNT_NON_EXIST);
        }
    }

    @GetMapping(value = "/sys_info")
    public Result sysInfo(){
        Map<String,Object> map = new HashMap();
        //服务器信息
        SystemInfoVo systemInfoVo = SysInfoUtil.property();
        systemInfoVo.setServerIP(serverConfig.getHost());
        systemInfoVo.setLocalPort(serverConfig.getServerPort());
        systemInfoVo.setFileUploadPath(FileHandleUtil.getUploadPath());
        systemInfoVo.setLogDir(FileHandleUtil.getLogPath());
        map.put("systemInfoVo",systemInfoVo);
        return success(map);
    }
}
