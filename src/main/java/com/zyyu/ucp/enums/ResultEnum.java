package com.zyyu.ucp.enums;

/**
 * 返回结果枚举
 */
public enum ResultEnum {
    /**成功*/
    SUCCESS(2000, "成功"),
    /**程序异常*/
    ERROR(5000, "系统异常"),
    /**参数空*/
    PARAM_BLANK(4000, "参数为空"),
    /**数据异常*/
    DATA_BLANK(4001, "数据为空"),
    /**失败*/
    FAIL(4002, "失败"),
    /**用户未登录*/
    UNAUTHORIZED(3000,"用户未登录"),
    /**账号不存在或密码错误*/
    ACCOUNT_NON_EXIST(30001,"账号不存在或密码错误"),
    /**Token过期*/
    TOKEN_EXPIRED(3002,"令牌过期"),
    /**非法Token*/
    TOKEN_INVALID(3003,"非法令牌");

    /**状态码*/
    private int code;
    /**结果信息*/
    private String message;

    ResultEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
