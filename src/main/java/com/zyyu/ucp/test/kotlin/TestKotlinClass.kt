package com.zyyu.ucp.test.kotlin


/**
 * kotlin中const只能用在顶级属性，以及object对象的属性中（伴随对象也是obejct）。
 */
const val CATGORY_EDOC = "edoc"

/**
 * class 关键字修饰，普通的类文件和java的class差不多
 */
class TestKotlinClass {

    /**
     * 定义伴随对象，
     * 1、类似java文件中定义一个static final修饰的常量
     * 因为在Kotlin中，被class修饰的类中是不能直接使用const关键字的，
     * 只有被object修饰的类可以直接使用const关键字
     * 2、类似与java中定义静态方法
     */
    companion object{
        //类似java中定义常量
        const val tag:String="TestKotlinObject"

        //类似java的静态方法
        @JvmStatic
        fun getInstance():TestKotlinClass{
            return TestKotlinClass()
        }
    }

    /** private修饰私有变量 */
    private val name:String="zouyi"

    /** 默认是public修饰 */
    val age:Int = 20

    /**
     * 定义普通get函数，返回值类型写在参数括号后面
     */
    fun getMyName():String{
        return name
    }
}
