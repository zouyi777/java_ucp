package com.zyyu.ucp.test;

import java.io.*;

/**
 * java IO
 */
public class TestIO {

    public static void main(String[] args) throws IOException {

        String filePathIn = "C:\\Users\\zouyi\\Desktop\\javaio_test.txt";
        String filePathOut = "C:\\Users\\zouyi\\Desktop\\javaio_test1.txt";

        FileInputStream fileInputStream = new FileInputStream(filePathIn);
        File file = new File(filePathIn);
        if(file.isFile() && file.exists()){
            FileInputStream fileInputStream1 =new FileInputStream(file);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(filePathOut);
        File outFile = new File(filePathOut);
        if(!outFile.exists()){
            outFile.mkdir();
            FileOutputStream fileOutputStream1 = new FileOutputStream(outFile);
        }

        FileReader fileReader = new FileReader(filePathIn);
        fileReader.read();
        FileWriter fileWriter = new FileWriter(filePathOut);

        byte[] b = new byte[21];
        while (fileInputStream.read(b)>0){
            System.out.println(new String(b));
            fileOutputStream.write(b);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
