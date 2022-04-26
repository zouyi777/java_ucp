package com.zyyu.ucp.test.socket.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端新开线程类：当用户输入退出指令后，while循环判定为false，
 * 但是此时线程还在br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 * 等待消息，所以跟服务器的关系发送要对应好。
 */
public class ClientThread extends Thread{

    Socket socket;
    public ClientThread(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
