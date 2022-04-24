package com.zyyu.ucp.test.threadpool;

/**
 * 可以自定义一个任务接口
 * 让MyTask 实现此接口，从而替代Runnable
 */
public interface MyTaskInterface {

    void exec();
}
