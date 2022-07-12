package com.zyyu.ucp.test.kotlin

/**
 * Kotlin 中缀函数(infix)
 * 您可以使用中缀表示法在Kotlin中进行函数调用，如果函数
 * 是成员函数（或扩展函数）。
 * 只有一个参数。
 * 标有 infix 关键字。
 */
class TestInfix {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
//        print(restInfixFun(2))
            val result = TestInfix() testInfixFun 2
            print(result)
        }
    }


    /**
     * infix 修饰中缀函数
     */
    infix fun testInfixFun(arg:Int):Int{
        return arg * 2 + 10
    }
}