package com.zyyu.ucp.test.http;

import java.io.*;
import java.net.Socket;

/**
 * http服务器线程
 */
public class serviceThread extends Thread {

    private Socket socket;

    public  serviceThread(Socket t_socket){
        socket = t_socket;
    }

    @Override
    public void run(){
        System.out.println("线程开始，打印该客户端的ip和端口"+socket.getLocalAddress() + ": " + socket.getLocalPort());
        InputStream clientInput = null;
        InputStreamReader clientInputStream = null;
        BufferedReader clientBufferReader = null;
        OutputStream clientOutStream = null;
        Writer clientWriter = null;
        System.out.println("打印该客户端的请求报文头");

        try{
            clientBufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String st = null;
            while ((st = clientBufferReader.readLine()) != null && st.length() != 0){
                System.out.println(st);
            }
            socket.shutdownInput();

            System.out.println("构造回应报文头并发送给还客户端");
            //构造这些报文和数据格式就是http协议规范的内容
            clientWriter = new OutputStreamWriter(socket.getOutputStream(),"UTF-8");
            clientWriter.write("HTTP/1.1 200 \r\n");
            clientWriter.write("Transfer-Encoding: chunked");
            clientWriter.write("Content-Type: text/html;charset=UTF-8\r\n");
            clientWriter.write("\r\n");
            clientWriter.write("helloWord,This is my http server\r\n");
            clientWriter.flush();

            /**
             * 每次请求结束就把socket关闭，这就是http短链接，无状态协议的体现。
             * 如果“俩个请求都通过一个socket来写数据,那么这个就是http长连接”,
             * 如果你写一个简单http服务器,那你实现的就不是长连接,每次请求都把socket.close()了
             * 所以判断一个http请求是不是长连接就是判断socket.close有没有执行
             */
            socket.close();
        }catch (Exception e){

        }
    }
}
