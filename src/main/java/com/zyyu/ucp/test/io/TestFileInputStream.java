package com.zyyu.ucp.test.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 对比BufferedInputStream和FileInputStream读取文件的时间
 */
public class TestFileInputStream {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\zouyi\\Desktop\\M3前端开发文档v2 (2).docx");
        long t = System.currentTimeMillis();
        byte[] buf = new byte[8192];
        while (fis.read(buf)!= -1) {

        }
        fis.close();
        t = System.currentTimeMillis() - t;
        System.out.println("FileInputStream遍历文件用了如下时间:" + t);
    }
}
