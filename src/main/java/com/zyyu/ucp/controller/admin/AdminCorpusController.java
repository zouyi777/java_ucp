package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.common.PageInfo;
import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.enums.CorpusCatgoryEnum;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.po.CorpusPo;
import com.zyyu.ucp.po.UserPo;
import com.zyyu.ucp.service.CorpusService;
import com.zyyu.ucp.service.WorksService;
import com.zyyu.ucp.vo.CorpusVo;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/corpus")
public class AdminCorpusController extends BaseController {

    @Autowired
    CorpusService corpusService;

    @PostMapping(value = "/list")
    public Result corpusList(@RequestBody PageInfo pageInfo){
        pageInfo = corpusService.getAllByPage(pageInfo);
        return success(pageInfo);
    }

    @GetMapping(value = "/detail")
    public Result corpusDetail(@RequestParam String corpusId){
        CorpusPo CorpusPo = corpusService.getById(Long.valueOf(corpusId));
        Mapper dozMapper = new DozerBeanMapper();
        CorpusVo corpusVo = dozMapper.map(CorpusPo,CorpusVo.class);
        return success(corpusVo);
    }

    @GetMapping(value = "/delete")
    public Result deleteCorpus(@RequestParam String corpusId){
        CorpusPo CorpusPo = new CorpusPo();
        CorpusPo.setId(Long.valueOf(corpusId));
        int result = corpusService.delete(CorpusPo);
        if(result==1){
            return success();
        }
        return fail("删除失败");
    }

    @PostMapping(value = "/update")
    public Result updateCorpus(@RequestBody CorpusVo corpusVo){
        Mapper dozerMapper = new DozerBeanMapper();
        CorpusPo CorpusPo = dozerMapper.map(corpusVo,CorpusPo.class);
        int result = corpusService.update(CorpusPo);
        if(result==1){
            return success();
        }
        return fail("修改失败");
    }

    @PostMapping(value = "/add")
    public Result addCorpus(@RequestBody CorpusVo corpusVo){

        if(corpusService.getVoByContent(corpusVo)!=null){
            return fail("此语料已存在！");
        }

        Mapper dozerMapper = new DozerBeanMapper();
        CorpusPo corpusPo = dozerMapper.map(corpusVo,CorpusPo.class);

        int result = corpusService.add(corpusPo);
        if(result==1){
            return success();
        }
        return fail("新增失败");
    }

    /**
     * 获取语料类型的接口
     * @return
     */
    @GetMapping(value = "/getcorpus_catgory")
    public Result getCorpusCatgory(){
        CorpusCatgoryEnum[] values= CorpusCatgoryEnum.values();
        return success(values);
    }

    @GetMapping(value = "/isContentExit")
    public Result isContentExit(@RequestParam String content){

        if(StringUtils.isNotEmpty(content)){

            CorpusVo paramCorpus = new CorpusVo();
            paramCorpus.setContent(content);

            CorpusVo corpusVo = corpusService.getVoByContent(paramCorpus);
            if(corpusVo==null){
                return success(false);
            }
            return success(true);
        }
        return fail(ResultEnum.PARAM_BLANK);
    }
}
