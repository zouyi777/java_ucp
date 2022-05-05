package com.zyyu.ucp.test.socket.chatroom;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * 主要注意的就是客户端与服务器端的发送接受关系，必须一一对应好，
 * 同样，客户端单线程实现不了一直监听服务器推送信息以及一直监听用户发送信息，
 * 在规定的退出指令中，需要注意当客户端输入推出指令后，客户端等待服务器推送的消息的线程仍在等待，
 * 所以我让服务器给本人也推送一个退出信息，不然也会爆出异常。
 */
public class Client {

    public static void main(String[] args) {
        Socket socket=null;
        try {
            //Socket第一种方式连接
//            socket = new Socket("127.0.0.1",1859);
            //Socket第二种方式连接
            socket = new Socket();
            SocketAddress address = new InetSocketAddress("127.0.0.1",1859);
            socket.connect(address);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("请输入用户名：");
            Scanner sc = new Scanner(System.in);
            bw.write(sc.next());
            bw.newLine();
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(br.readLine());

            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();

            while(true) {
                System.out.print("请输入发送的内容：");
                String input = sc.next();
                bw.write(input);
                bw.newLine();
                bw.flush();
                if(input.equals("byebye")) {
                    clientThread.interrupt();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
