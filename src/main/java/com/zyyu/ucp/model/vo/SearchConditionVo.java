package com.zyyu.ucp.model.vo;

import com.zyyu.ucp.model.PageInfo;

import java.util.Map;

/**
 * 查询条件Vo
 */
public class SearchConditionVo {

    //分页信息
    private PageInfo pageInfo;
    //查询条件
    private Map condition;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Map getCondition() {
        return condition;
    }

    public void setCondition(Map condition) {
        this.condition = condition;
    }

}
