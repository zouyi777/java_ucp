package com.zyyu.ucp.test.threadpool;

public class TestMySelfThreadPool {
    private static final int THREAD_NUM = 2;//线程池中的线程个数
    private static final int TASK_NUM = 5;//任务的个数

    public static void main(String[] args) {
        ThreadPool myPool = new ThreadPool(THREAD_NUM,TASK_NUM);
        for (int i=0;i<TASK_NUM;i++) {
            myPool.execute(new MyTask("task_"+i));
        }

    }

    /**
     * 实现Runnable的原因是，其实就是统一所有任务的执行方法，方便线程池中的线程调用
     * 也可以不用Runnable,用自定义的MyTaskInterface接口
     */
    static class MyTask implements Runnable{

        private String name;
        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task :"+name+" end...");

        }

        @Override
        public String toString() {
            return "name = "+name;
        }
    }
}
