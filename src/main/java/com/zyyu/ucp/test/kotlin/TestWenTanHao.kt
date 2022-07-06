package com.zyyu.ucp.test.kotlin


/**
 * 测试 Kotlin的 ? 和 !!
 */
object  TestWenTanHao{

    @JvmStatic
    fun main(args: kotlin.Array<String>){

        print(getName("zouyi"))

        //!!表示：通知编译器不做非空校验。如果运行时发现变量为空，就扔出异常
        print(getName(null!!))
    }

    fun getName(args:String):String{
        return args
    }
}