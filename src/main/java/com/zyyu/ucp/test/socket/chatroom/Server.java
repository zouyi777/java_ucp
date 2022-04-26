package com.zyyu.ucp.test.socket.chatroom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端
 */
public class Server {

    //用来储存每一个用户的线程
    List<ThreadSocket> clients = new ArrayList<ThreadSocket>();

    /**
     * 创建serverSocket链接，死循环用以监听客户端用户的链接，当一个用户链接之后，就为其新开一个线程。
     * 通过这个新开的线程来实现对每个用户的功能
     */
    public void start() throws IOException {
        ServerSocket server = new ServerSocket(1859);
        while(true) {
            Socket socket = server.accept();
            System.out.println(socket.getInetAddress().getHostAddress()+"正在链接！！！");
            ThreadSocket client = new ThreadSocket(socket);
            new Thread(client).start();
        }
    }


    /**
     * 创建了一个线程内部类，方便我直接使用这个线程数组.
     * 因为在一个用户登录的时候，服务器会给每一个用户广播一条欢迎消息，
     * 每个用户连接只有一次，所以我选择在线程的构造函数中将此线程添加到线程数组，
     * 并执行广播方法send()，此方法通过遍历线程数组，给每个线程的socket添加输出流，推送欢迎消息
     */
    class ThreadSocket implements Runnable {

        Socket socket;
        String name;


        public ThreadSocket(Socket socket) throws IOException {
            this.socket = socket;
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = br.readLine();
            String welcome = name+"["+socket.getInetAddress().getHostAddress()+"]来到了房间";
            clients.add(this);
            send(welcome);
            System.out.println(welcome);
        }

        /**
         * 发送消息，因为是聊天室，所以这里是群发
         * @param welcome
         * @throws IOException
         */
        private void send(String welcome) throws IOException {
            for (ThreadSocket c : clients) {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(c.socket.getOutputStream()));
                bw.write(welcome);
                bw.newLine();
                bw.flush();
            }
        }


        /**
         * 由于用户发送消息需要服务器一直监听，等待接受，所以必须写在死循环中，需要同客户端约定一个退出方式，
         * 因为一旦一方关闭，另一方socket.getInputStream()就会接受不到，此时程序会不断循环输出异常
         */
        @Override
        public void run() {
            while(true) {
                BufferedReader br;
                try {
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg = br.readLine();
                    String name1 = name+"["+socket.getInetAddress().getHostAddress()+"]";
                    if(msg.equals("byebye")) {
                        System.out.println(name1+"离开了聊天室");
                        send(name1+"离开了聊天室");
                        clients.remove(this);
                        socket.close();
                        break;
                    }
                    send(name1+":"+msg);
                    System.out.println(name1+":"+msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
