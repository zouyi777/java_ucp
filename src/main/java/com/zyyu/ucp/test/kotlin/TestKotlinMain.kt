package org.zouyi.common.test

import com.zyyu.ucp.test.kotlin.CATGORY_EDOC
import com.zyyu.ucp.test.kotlin.TestKotlinClass
import com.zyyu.ucp.test.kotlin.TestKotlinObject

/**
 * Kotlin的第一种main函数入口
 * 需要添加object关键字和@JvmStatic注解
 * 在Kotlin中的定义变量和函数，默认缺省就是public修饰
 */
object TestKotlinMain {

    /**声明一个常量*/
    val ACTION_SHOW:Int=10

    /**声明一个变量*/
    var addresss=null


    @JvmStatic
    fun main(args:Array<String>){

        System.out.println("常量的声明:"+ACTION_SHOW)

        //1、Kotlin创建对象并调用成员变量和方法
//        var testKotlinClass = TestKotlinClass()
        //2、使用kotlin静态方法创建对象
        var testKotlinClass = TestKotlinClass.getInstance()

        System.out.println("调用成员变量："+ TestKotlinClass.tag)
        System.out.println("调用成员变量："+testKotlinClass.age)
        System.out.println("调用成员方法："+testKotlinClass.getMyName())

        //2、Kotlin直接调用对象，并调用方法
        System.out.println("直接调用对象："+ TestKotlinObject.getMyCondition())

        //调用顶级属性，CATGORY_EDOC来自TestKotlinClass文件
        System.out.println(CATGORY_EDOC)

//        var index = getNameIndex("11a22")
//        var index = getNameIndex(null!!)
        var index = getNameIndex1(null)
        print(index)
    }


    private fun getNameIndex(args: String): Int {
        if(args!=null){
            return args.indexOf("a")
        }
        return -1

    }

    private fun getNameIndex1(args: String?): Int {
        if(args!=null){
            return args.indexOf("a")
        }
        return -1

    }


    override fun toString(): String {
        return super.toString()
    }
}