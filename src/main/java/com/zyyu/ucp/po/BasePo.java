package com.zyyu.ucp.po;

import java.sql.Timestamp;

/**
 * 基础Po
 */
public abstract class BasePo {
    private Long id;
    /**创建时间*/
    private Timestamp createTime;
    /**更新时间*/
    private Timestamp updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
