package com.zyyu.ucp.model.vo;

import com.zyyu.ucp.model.PageInfo;

/**
 * 查询条件基本Vo
 */
public class SearchConditionBaseVo {

    //分页信息
    private PageInfo pageInfo;
    //开始日期
    private String createTimeStart;
    //结束日期
    private String createTimeEnd;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

}
