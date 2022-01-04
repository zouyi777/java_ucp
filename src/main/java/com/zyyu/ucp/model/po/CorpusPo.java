package com.zyyu.ucp.model.po;

import com.zyyu.ucp.enums.CorpusCatgoryEnum;

/**
 * 语料PO
 */
public class CorpusPo extends BasePo{

    private String content;
    private CorpusCatgoryEnum catgory;
    private Long donateId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CorpusCatgoryEnum getCatgory() {
        return catgory;
    }

    public void setCatgory(CorpusCatgoryEnum catgory) {
        this.catgory = catgory;
    }

    public Long getDonateId() {
        return donateId;
    }

    public void setDonateId(Long donateId) {
        this.donateId = donateId;
    }

}
