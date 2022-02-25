package com.zyyu.ucp.model.vo;

/**
 * 语料查询条件
 */
public class SearchConditionCorpusVo extends SearchConditionBaseVo{

    //内容关键字
    private String content;
    //贡献者用户名
    private String donateName;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDonateName() {
        return donateName;
    }

    public void setDonateName(String donateName) {
        this.donateName = donateName;
    }

}
