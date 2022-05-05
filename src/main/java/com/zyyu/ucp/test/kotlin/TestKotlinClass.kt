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
     * 定义伴随对象，类似java文件中定义一个static final修饰的常量
     * 因为在Kotlin中，被class修饰的类中是不能直接使用const关键字的，
     * 只有被object修饰的类可以直接使用const关键字
     */
    companion object{
        const val tag:String="TestKotlinObject"
    }

    /** private修饰私有变量 */
    private var name:String="zouyi"

    /** 默认是public修饰 */
    var age:Int = 20

    /**
     * 定义普通get函数，返回值类型写在参数括号后面
     */
    fun getMyName():String{
        return name
    }
}
