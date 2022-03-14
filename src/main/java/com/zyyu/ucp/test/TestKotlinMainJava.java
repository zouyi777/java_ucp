package com.zyyu.ucp.test;

import static com.zyyu.ucp.test.TestKotlinClassKt.CATGORY_EDOC;

/**
 * 专门测试java调用Kotlin的mian函数
 */
public class TestKotlinMainJava {

    public static void main(String[] args) {

        //java直接调用kotlin的顶级属性const
        System.out.println(CATGORY_EDOC);
    }
}
