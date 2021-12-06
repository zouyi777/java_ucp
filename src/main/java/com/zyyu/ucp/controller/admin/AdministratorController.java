package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.annotation.CurrAccount;
import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.po.AdministratorPo;
import com.zyyu.ucp.service.AdministratorService;
import com.zyyu.ucp.vo.AdministratorVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/administrator")
public class AdministratorController extends BaseController {

    @Autowired
    AdministratorService administratorService;

    @PostMapping(value = "/list")
    public Result list(@RequestBody PageInfo pageInfo){
        pageInfo = administratorService.getAllByPage(pageInfo);
        return success(pageInfo);
    }

    @GetMapping(value = "/detail")
    public Result detail(@RequestParam String adminiId){
        AdministratorPo administratorPo = administratorService.getById(Long.valueOf(adminiId));
        Mapper dozMapper = new DozerBeanMapper();
        AdministratorVo administratorVo = dozMapper.map(administratorPo,AdministratorVo.class);
        return success(administratorVo);
    }

    @GetMapping(value = "/delete")
    public Result delete(@RequestParam String adminiId){
        AdministratorPo administratorPo = new AdministratorPo();
        administratorPo.setId(Long.valueOf(adminiId));
        int result = administratorService.delete(administratorPo);
        if(result==1){
            return success();
        }
        return fail("删除失败");
    }

    @PostMapping(value = "/update")
    public Result update(@RequestBody AdministratorVo administratorVo){
        Mapper dozerMapper = new DozerBeanMapper();
        AdministratorPo administratorPo = dozerMapper.map(administratorVo,AdministratorPo.class);
        int result = administratorService.update(administratorPo);
        if(result==1){
            return success();
        }
        return fail("修改失败");
    }

    @PostMapping(value = "/add")
    public Result add(@RequestBody AdministratorVo administratorVo){
        Mapper dozerMapper = new DozerBeanMapper();
        AdministratorPo administratorPo = dozerMapper.map(administratorVo,AdministratorPo.class);

        int result = administratorService.add(administratorPo);
        if(result==1){
            return success();
        }
        return fail("新增失败");
    }

}
