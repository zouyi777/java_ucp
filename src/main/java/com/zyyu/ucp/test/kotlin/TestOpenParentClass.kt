package com.zyyu.ucp.test.kotlin

/**
 * koutlin中 “类默认不可继承，方法默认不可重写”
 * 需要继承或者重写都需要加open关键字
 */
open class TestOpenParentClass{

    open fun testFun(arg:String):Int{
        return arg.indexOf("a")
    }

}