@file:JvmName("TestKotlin1")

package com.zyyu.ucp.test.kotlin

/**
 *  Kotlin的另外一种main函数入口
 * 需要在文件头部添加@file注解
 */
fun main(args:Array<String>){

    System.out.println(TestKotlinObject.getMyCondition())
    //调用顶级属性
    System.out.println(CATGORY_EDOC)


}