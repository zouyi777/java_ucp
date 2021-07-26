package com.zyyu.ucp.controller;

import com.zyyu.ucp.common.Result;
import com.zyyu.ucp.enums.ResultEnum;

public class BaseController {

    /**返回成功结果*/
   protected Result success(Object data){
       return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage(),data);
    }
    /**返回失败*结果*/
    protected Result fail(ResultEnum resultEnum){
        return new Result(resultEnum.getCode(),resultEnum.getMessage());
    }
}
