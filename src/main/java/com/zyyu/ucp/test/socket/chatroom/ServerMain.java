package com.zyyu.ucp.test.socket.chatroom;

import java.io.IOException;

/**
 * 启动聊天室服务端
 */
public class ServerMain {

    public static void main(String[] args) {
        try {
            new Server().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
