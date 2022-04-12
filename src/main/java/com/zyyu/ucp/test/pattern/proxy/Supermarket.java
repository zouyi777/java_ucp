package com.zyyu.ucp.test.pattern.proxy;

/**
 * 静态代理类
 * Proxy(代理类):也叫委托类，持有对真实主题的引用，
 * 在其所实现的接口中调用真实主题类中相应的接口方法执行。
 */
public class Supermarket implements IBuy {

    private IBuy consumer;

    public Supermarket(IBuy consumer){
        this.consumer = consumer;
    }

    @Override
    public void buy() {
        System.out.println("超市向工厂购买商品");
        consumer.buy();
        System.out.println("超市提供售后服务");
    }
}
