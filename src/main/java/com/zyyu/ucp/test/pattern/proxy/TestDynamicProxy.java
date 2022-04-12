package com.zyyu.ucp.test.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理模式
 */
public class TestDynamicProxy {

    public static void main(String[] args) {

        Consumer1 consumer1 = new Consumer1();
        IBuy1 consumerBuy = (IBuy1) Proxy.newProxyInstance(consumer1.getClass().getClassLoader(),
                consumer1.getClass().getInterfaces(),
                new Buy1Proxy(consumer1));
        consumerBuy.returnGoods();
        consumerBuy.buy();
    }

}
