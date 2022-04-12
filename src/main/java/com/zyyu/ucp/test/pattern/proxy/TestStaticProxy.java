package com.zyyu.ucp.test.pattern.proxy;

/**
 * 静态代理模式
 *
 * 静态代理的代理类在编译时期已经存在，一般需要先定义接口，被代理对象和代理对象共同实现这个接口
 * 优点:
 * 1.职责清晰，被代理角色只实现实际的业务逻辑，代理对象实现附加的处理逻辑
 * 2.扩展性高，可以更换不同的代理类，实现不同的代理逻辑
 * 缺点
 * 如果代理的业务类型增加，需要新增接口方法，同时"代理类"和"被代理类"都需要对应的去新增方法。
 * 如果新增的业务量非常多，那么"代理类"的代码将会暴增，可读性降低难以维护。
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        Consumer consumer =new Consumer();
        Supermarket supermarket = new Supermarket(consumer);
        supermarket.buy();
    }
}
