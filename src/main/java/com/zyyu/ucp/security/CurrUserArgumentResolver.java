package com.zyyu.ucp.security;

import com.zyyu.ucp.annotation.CurrUser;
import com.zyyu.ucp.constants.Constants;
import com.zyyu.ucp.utils.JwtUtil;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义参数解析器
 * 根据token取值获取当前登录用户信息
 */
public class CurrUserArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * url请求进来后走完其他一些拦截器等之后会在进入方法之前执行supportsParameter依次传入要请求方法的参数
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.hasParameterAnnotation(CurrUser.class)) {
            return true;
        }
        return false;
    }

    /**
     *  supportsParameter()返回值为true时，会执行本方法
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        String token = request.getHeader(Constants.AUTH_TOKEN);
        Class<?> parameterType = methodParameter.getParameterType();

        /**根据参数类型：果是long，则获取userId，如果是User对象，则获取用户对象**/
//        if (parameterType.isAssignableFrom(SysUser.class)) {
//            SysUser user = new SysUser();
//            user.setUserId(1L);
//            user.setUserName("昂克");
//
//            return user;
//        } else if (parameterType.isAssignableFrom(Long.class)) {
//             getUserId(token)
//            Long userId = 1L;
//
//            return userId;
//        }
        String userId = JwtUtil.getUserId(token);
        return userId;
    }
}
