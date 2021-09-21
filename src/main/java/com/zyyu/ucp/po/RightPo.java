package com.zyyu.ucp.po;

/**
 * 权限
 */
public class RightPo extends BasePo{

    private String rightName;
    private String rightRule;

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
}
