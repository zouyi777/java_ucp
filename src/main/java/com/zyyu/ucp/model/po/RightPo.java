package com.zyyu.ucp.model.po;

/**
 * 权限
 */
public class RightPo extends BasePo{

    private String rightName;
    private String rightRule;
    private String description;

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public String getRightRule() {
        return rightRule;
    }

    public void setRightRule(String rightRule) {
        this.rightRule = rightRule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
