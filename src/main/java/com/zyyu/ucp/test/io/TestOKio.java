package com.zyyu.ucp.test.io;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

import java.io.*;

/**
 * 测试Okio
 */
public class TestOKio {

    public static void main(String[] args) throws IOException {

        File file=new File("C:\\Users\\zouyi\\Desktop\\okio_test.txt");
        InputStream in=new FileInputStream(file);
        BufferedSource source = Okio.buffer(Okio.source(in));  //创建BufferedSource
        String s = source.readUtf8();  //以UTF-8读
        System.out.println(s);     //打印

        BufferedSink sink=Okio.buffer(Okio.sink(new File("C:\\Users\\zouyi\\Desktop\\okio_test1.txt")));
        sink.writeUtf8(s);
        source.close();
        sink.close();
    }
}
