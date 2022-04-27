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

            socket.close();
        }catch (Exception e){

        }
    }
}
