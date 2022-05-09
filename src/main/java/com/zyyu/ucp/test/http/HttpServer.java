package com.zyyu.ucp.test.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 自定义http服务器
 * java模拟http协议在服务器端的实现
 */
public class HttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1860);
        Socket socket;
        while (true){
            System.out.println("正在监听------");
            socket = serverSocket.accept();
            System.out.println("监听到一个客户端请求");
            System.out.println("为该客户端创建一个线程实列并开始运行该线程");
            serviceThread thread1 = new serviceThread(socket);
            System.out.println("线程名="+thread1.getName()+"线程id="+thread1.getId());
            thread1.start();
        }
    }
}


