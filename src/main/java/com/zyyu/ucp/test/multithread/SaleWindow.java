package com.zyyu.ucp.test.multithread;

public class SaleWindow implements Runnable{

    // 初始化票数10
    private int ticket = 10;

    //线程的锁
    private Object lock = new Object();

    /**
     * 使用Object作同步锁
     */
//    @Override
//    public void run() {
//        // 获取线程的名称，比如Thread-0，并将它截掉Thread-取0这个数字标识，为了构造下面卖票窗口名称
//        int threadNum = Integer.parseInt(Thread.currentThread().getName().substring(7));
//        String saleWindowName = "销售窗口" + threadNum;
//        // 开始买票
//        while (true) {
//            //加上synchronized，并加入对象锁，new一个任意对象即可，我们这里使用Object来解决同步问题，注意这里必须是公用同一个锁lock
//            synchronized (lock) {
//
//                if (ticket > 0) {
//                    // 这里为了演示出线程不同步的问题，让线程睡眠一段时间，延时）
//                    try {
//                        Thread.sleep(1000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(saleWindowName + " 卖 出 了 " + ticket-- + " 号 票 ！");
//                } else {
//                    break;
//                }
//            }
//        }
//    }


    /**
     * 使用同步方法,是用的this作同步锁
     */
//    @Override
//    public void run() {
//
//        // 开始买票
//        while (true) {
//            // 当没有票了结束
//            if (!saleSuccess()) {
//                break;
//            }
//        }
//    }

    public synchronized boolean saleSuccess() {
        // 获取线程的名称，比如Thread-0，并将它截掉Thread-取0这个数字标识，为了构造下面卖票窗口名称
        int threadNum = Integer.parseInt(Thread.currentThread().getName().substring(7));
        String saleWindowName = "销售窗口" + threadNum;
        if (ticket > 0) {
            // 这里为了演示出线程不同步的问题，让线程睡眠一段时间，延时）
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(saleWindowName + " 卖 出 了 " + ticket-- + " 号 票 ！");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 使用this作同步锁
     */
    @Override
    public void run() {
        // 获取线程的名称，比如Thread-0，并将它截掉Thread-取0这个数字标识，为了构造下面卖票窗口名称
        int threadNum = Integer.parseInt(Thread.currentThread().getName().substring(7));
        String saleWindowName = "销售窗口" + threadNum;
        // 开始买票
        while (true) {
            //加上synchronized，并加入对象锁，new一个任意对象即可，我们这里使用Object来解决同步问题，注意这里必须是公用同一个锁lock
            synchronized (this) {
                if (ticket > 0) {
                    // 这里为了演示出线程不同步的问题，让线程睡眠一段时间，延时）
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(saleWindowName + " 卖 出 了 " + ticket-- + " 号 票 ！");
                } else {
                    break;
                }
            }
        }
    }



    public static void main(String[] args) {
        // 创建了销售窗口对象
        SaleWindow sw = new SaleWindow();
        // 启动线程，让第一个窗口开始买票
        new Thread(sw).start();
        // 启动线程，让第二个窗口开始买票
        new Thread(sw).start();
        // 启动线程，让第三个窗口开始买票
        new Thread(sw).start();

    }
}
