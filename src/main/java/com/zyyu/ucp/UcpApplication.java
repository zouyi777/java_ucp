package com.zyyu.ucp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zyyu.ucp.mapper")
public class UcpApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcpApplication.class, args);
    }

}
