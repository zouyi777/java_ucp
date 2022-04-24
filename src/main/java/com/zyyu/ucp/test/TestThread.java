package com.zyyu.ucp.test;

public class TestThread {

    public static void main(String[] args) {
        //传Runable对象方式
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(11111);
            }
        });
        thread.start();

        //继承Thread方式
        class MyThread extends Thread{

            @Override
            public void run() {
                System.out.println(2222);
            }
        }
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
