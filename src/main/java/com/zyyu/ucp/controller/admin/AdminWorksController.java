package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.Result;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.model.po.WorksPo;
import com.zyyu.ucp.service.WorksService;
import com.zyyu.ucp.model.vo.WorksVo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/works")
public class AdminWorksController extends BaseController {

    @Autowired
    WorksService worksService;

    @PostMapping(value = "/list")
    public Result worksList(@RequestBody PageInfo pageInfo){
        pageInfo = worksService.getAllByPage(pageInfo);
        return success(pageInfo);
    }

    @GetMapping(value = "/detail")
    public Result worksDetail(@RequestParam String worksId){
        WorksPo worksPo = worksService.getById(Long.valueOf(worksId));
        Mapper dozMapper = new DozerBeanMapper();
        WorksVo worksVo = dozMapper.map(worksPo,WorksVo.class);
        return success(worksVo);
    }

    @GetMapping(value = "/delete")
    public Result deleteWorks(@RequestParam String worksId){
        WorksPo worksPo = new WorksPo();
        worksPo.setId(Long.valueOf(worksId));
        int result = worksService.delete(worksPo);
        if(result==1){
            return success();
        }
        return fail("删除失败");
    }

    @PostMapping(value = "/update")
    public Result updateWorks(@RequestBody WorksVo worksVo){
        Mapper dozerMapper = new DozerBeanMapper();
        WorksPo worksPo = dozerMapper.map(worksVo,WorksPo.class);
        int result = worksService.update(worksPo);
        if(result==1){
            return success();
        }
        return fail("修改失败");
    }

    @PostMapping(value = "/add")
    public Result addWorks(@RequestBody WorksVo worksVo){
        Mapper dozerMapper = new DozerBeanMapper();
        WorksPo worksPo = dozerMapper.map(worksVo,WorksPo.class);

        int result = worksService.add(worksPo);
        if(result==1){
            return success();
        }
        return fail("新增失败");
    }

}
