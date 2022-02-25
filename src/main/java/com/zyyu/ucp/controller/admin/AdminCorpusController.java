package com.zyyu.ucp.controller.admin;

import com.zyyu.ucp.model.PageInfo;
import com.zyyu.ucp.model.Result;
import com.zyyu.ucp.controller.BaseController;
import com.zyyu.ucp.enums.CorpusCatgoryEnum;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.model.po.CorpusPo;
import com.zyyu.ucp.model.vo.SearchConditionCorpusVo;
import com.zyyu.ucp.model.vo.SearchConditionBaseVo;
import com.zyyu.ucp.service.CorpusService;
import com.zyyu.ucp.model.vo.CorpusVo;
import com.zyyu.ucp.utils.MD5Util;
import com.zyyu.ucp.utils.StringUcpUtil;
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
        String content = corpusVo.getContent();
        if(StringUtils.isEmpty(content)){
            return fail(ResultEnum.PARAM_BLANK);
        }
        //去掉空格所有标点符号
        content = StringUcpUtil.getPureString(content);
        if(StringUtils.isEmpty(content)){
            return fail(ResultEnum.PARAM_BLANK);
        }
        corpusVo.setContentMD5(MD5Util.getMD5(content));

        if(corpusService.getVoByContentMD5(corpusVo)!=null){
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

    /**
     * 校验语料是否存在
     * @param content
     * @return
     */
    @GetMapping(value = "/isContentExit")
    public Result isContentExit(@RequestParam String content){

        if(StringUtils.isNotEmpty(content)){
            //去掉空格所有标点符号
            content = StringUcpUtil.getPureString(content);
            if(StringUtils.isEmpty(content)){
                return fail(ResultEnum.PARAM_BLANK);
            }

            CorpusVo paramCorpus = new CorpusVo();
            paramCorpus.setContentMD5(MD5Util.getMD5(content));

            CorpusVo corpusVo = corpusService.getVoByContentMD5(paramCorpus);
            return success(corpusVo);
        }
        return fail(ResultEnum.PARAM_BLANK);
    }

    @PostMapping(value = "/search_corpus")
    public Result searchCorpus(@RequestBody SearchConditionCorpusVo searchConditionVo){
        PageInfo pageInfo = corpusService.searchByCondition(searchConditionVo);
        return success(pageInfo);
    }
}
