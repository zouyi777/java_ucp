package com.zyyu.ucp.test.pattern.proxy;

/**
 * RealSubject(真实主题类):也叫做被代理类或被委托类，定义了代理所表示的真实对象，
 * 负责具体业务逻辑的执行，客户端可以通过代理类间接的调用真实主题类的方法。
 */
public class Consumer1 implements IBuy1 {
    @Override
    public void buy() {
        System.out.println("消费者购买商品");
    }

    @Override
    public void returnGoods() {
        System.out.println("消费者退货");
    }
}
