package com.zyyu.ucp.controller;

import com.zyyu.ucp.model.Result;
import com.zyyu.ucp.enums.ResultEnum;

public class BaseController {

    /**返回成功结果*/
   protected Result success(Object data){
       return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage(),data);
    }
    /**返回成功结果*/
    protected Result success(){
        return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage());
    }
    /**返回失败*结果*/
    protected Result fail(ResultEnum resultEnum){
        return new Result(resultEnum.getCode(),resultEnum.getMessage());
    }

    /**返回失败*结果*/
    protected Result fail(String message){
        return new Result(ResultEnum.FAIL.getCode(),message);
    }
}
