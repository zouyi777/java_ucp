package com.zyyu.ucp.test.io;

import okio.BufferedSource;
import okio.Okio;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 对比BufferedInputStream和OkioBufferedSource的读取文件的时间
 * BufferedInputStream --> BufferedOutputStream，需要经过“两次数据拷贝”
 * 而Okio的BufferedSource --> BufferedSink，底层使用双向循环链表，只需要“一次数据拷贝”
 */
public class TestOkioBufferedSource {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\zouyi\\Desktop\\M3前端开发文档v2 (2).docx");
        BufferedSource source = Okio.buffer(Okio.source(fis));
        long t = System.currentTimeMillis();
//        source.readUtf8();
        byte[] buff = new byte[1024];
        while (source.read(buff) != -1) {

        }
        t = System.currentTimeMillis() - t;
        System.out.println("OkioBufferedSource遍历文件用了如下时间:" + t);
    }
}
