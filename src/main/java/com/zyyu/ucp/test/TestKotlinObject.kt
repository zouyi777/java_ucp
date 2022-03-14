package com.zyyu.ucp.test

import java.util.*

/**
 * object 修饰，在调用的时候不需要创建对象，可以直接访问
 * 类似java中的静态类
 */
object TestKotlinObject {

    /** 被object修饰的类文件可以直接使用const关键字 */
    const val tag:String="TestKotlinObject"

    fun getMyCondition():Map<String,String>{
        var map = HashMap<String,String>()
        map.put("name","zhangsan")
        map.put("age","30")
        return map
    }
}