package com.zyyu.ucp.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解,获取当前登录用户信息
 * 作用于方法里的参数上面
 * 用于获取的用户的信息，如果是long，则获取userId，如果是User对象，则获取用户对象
 */
@Target(ElementType.PARAMETER)// 作用于方法里的参数上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrUser {
}
