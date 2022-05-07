package com.zyyu.ucp.test.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 对比BufferedInputStream和FileInputStream读取文件的时间
 */
public class TestBufferedInputStream {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\zouyi\\Desktop\\M3前端开发文档v2 (3).docx");
        BufferedInputStream bis = new BufferedInputStream(fis);
        long t = System.currentTimeMillis();
        /*even though the next read() also read one byte, but because
        BufferedInputStream has an internal buffer,when first time to read,
        it will read in a whole buffer of byte from hard disk, then digest
        these bytes one by one in memory */
        byte[] buff = new byte[1024];
        while (bis.read(buff) != -1) {

        }
        fis.close();
        t = System.currentTimeMillis() - t;
        System.out.println("BufferedInputStream遍历文件用了如下时间:" + t);
    }
}
