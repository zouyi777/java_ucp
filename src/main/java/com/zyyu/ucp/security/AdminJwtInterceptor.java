package com.zyyu.ucp.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyyu.ucp.model.Result;
import com.zyyu.ucp.constants.Constants;
import com.zyyu.ucp.enums.ResultEnum;
import com.zyyu.ucp.enums.TokenCheckEnum;
import com.zyyu.ucp.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @func 拦截token并验证，不通过则抛出异常
 */
public class AdminJwtInterceptor implements HandlerInterceptor {

    final static String ROLE_ADMINISTRATOR="administrator";
    final static String STRING_NULL = "null";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding(Constants.UTF8);
        String token = request.getHeader(Constants.AUTH_TOKEN);

        if (StringUtils.isEmpty(token) || STRING_NULL.equalsIgnoreCase(token)) {
            response.getWriter().print(getResult(ResultEnum.UNAUTHORIZED));
            return false;
        }
        TokenCheckEnum tokenCheckEnum = JwtUtil.checkToken(token,ROLE_ADMINISTRATOR);
        if(TokenCheckEnum.PASS.equals(tokenCheckEnum)){
            return true;
        }else if(TokenCheckEnum.EXPIRED.equals(tokenCheckEnum)){
            response.getWriter().print(getResult(ResultEnum.TOKEN_EXPIRED));
            return false;
        }else {
            response.getWriter().print(getResult(ResultEnum.TOKEN_INVALID));
            return false;
        }
    }

    protected String getResult(ResultEnum resultEnum) throws Exception{
        Result result =  new Result(resultEnum.getCode(),resultEnum.getMessage());
        return new ObjectMapper().writeValueAsString(result);
    }
}
