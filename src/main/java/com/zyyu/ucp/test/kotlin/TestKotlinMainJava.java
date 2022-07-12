package com.zyyu.ucp.test.kotlin;

/**
 * 专门测试java调用Kotlin的mian函数
 */
public class TestKotlinMainJava {

    public static void main(String[] args) {

        //java直接调用kotlin的顶级属性const
        System.out.println(com.zyyu.ucp.test.kotlin.TestKotlinClassKt.CATGORY_EDOC);

//        System.out.println(getNameIndex("11a33"));
        System.out.println(getNameIndex(null));
    }


    private static int getNameIndex(String args){
        int index = args.indexOf("a");
        return index;
    }
}
