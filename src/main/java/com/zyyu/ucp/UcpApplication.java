package com.zyyu.ucp;

import com.zyyu.ucp.utils.FileHandleUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
@MapperScan("com.zyyu.ucp.mapper")
public class UcpApplication {

    public static void main(String[] args) {
        //获取日志文件的存放目录
        String logbackDir = FileHandleUtil.getLogPath()+ File.separator;
        //将日志文件目录保存在System对象中，以便logback-spring.xml中读取
        System.setProperty("logbackDirKey", logbackDir);
        SpringApplication.run(UcpApplication.class, args);
    }

}
