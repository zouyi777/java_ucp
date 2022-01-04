package com.zyyu.ucp.controller;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.Result;
import com.zyyu.ucp.service.WorksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/works")
public class WorksController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(WorksController.class);

    @Autowired
    WorksService worksService;

    @PostMapping(value = "/list")
    public Result list(@RequestBody PageInfo pageInfo){
        pageInfo = worksService.getAllByPage(pageInfo);
        return success(pageInfo);
    }
}
