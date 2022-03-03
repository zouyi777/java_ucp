package com.zyyu.ucp.controller;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.Result;
import com.zyyu.ucp.enums.CorpusCatgoryEnum;
import com.zyyu.ucp.model.vo.SearchConditionCorpusVo;
import com.zyyu.ucp.service.CorpusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/corpus")
public class CorpusController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(CorpusController.class);

    @Autowired
    CorpusService corpusService;

    @PostMapping(value = "/list")
    public Result list(@RequestBody PageInfo pageInfo){
        pageInfo = corpusService.getAllByPage(pageInfo);
        return success(pageInfo);
    }

    @GetMapping(value = "/getcorpus_catgory")
    public Result getCorpusCatgory(){
        CorpusCatgoryEnum[] values= CorpusCatgoryEnum.values();
        return success(values);
    }

    @PostMapping(value = "/search_list")
    public Result searchCorpusList(@RequestBody SearchConditionCorpusVo searchConditionVo){
        PageInfo pageInfo = corpusService.searchByCondition(searchConditionVo);
        return success(pageInfo);
    }
}
