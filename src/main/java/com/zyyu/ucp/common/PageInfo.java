package com.zyyu.ucp.common;

import java.util.List;

public class PageInfo {
    /**当前页码*/
    private Integer currentPage;
    /**开始位置*/
    private Integer startIndex=0;
    /**每页条数*/
    private Integer pageSize=5;
    /**总条数*/
    private Integer totalCount;
    /**总页数*/
    private Integer totalPage;
    /**查询结果数据*/
    private List dataList;

    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        if(currentPage!=null){
            this.startIndex=(currentPage-1)*this.pageSize;
        }
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        //计算总页数
        if(totalCount!=null){
            this.totalPage=(int)Math.ceil((totalCount*1.0/this.pageSize));
        }
    }

    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Integer getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }
    public List getDataList(){
        return dataList;
    }
    public void setDataList(List dataList){
       this.dataList = dataList;
    }
}
