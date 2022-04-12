package com.zyyu.ucp.test.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 */
public class Buy1Proxy implements InvocationHandler {

    private IBuy1 consumer1;

    public Buy1Proxy(IBuy1 consumer1){
        this.consumer1 = consumer1;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("超市向工厂购买商品");
        Object returnObj =  method.invoke(consumer1,args);
        System.out.println("超市提供售后服务");
        return returnObj;
    }
}
