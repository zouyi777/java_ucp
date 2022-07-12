package com.zyyu.ucp.test.kotlin

/**
 * 子类继承TestOpenParentClass父类，父类必须添加open关键字
 */
class TestOpenChildClass:TestOpenParentClass() {

    /**
     * 子类重写父类方法，父类方法必须添加open关键字
     */
    override fun testFun(arg: String): Int {
        testPublic()

        return super.testFun(arg)
    }

    public fun testPublic() {

    }

    private fun testPrivate() {

    }
}