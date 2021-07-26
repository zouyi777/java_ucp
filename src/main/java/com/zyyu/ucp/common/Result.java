package com.zyyu.ucp.common;

/**
 * 封装返回结果
 */
public class Result {

    /**状态码*/
    private int code;
    /**结果信息*/
    private String message;
    /**数据*/
    private Object data;

    public Result() {
    }

    public Result(int code, String message) {
        this(code, message, null);
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
