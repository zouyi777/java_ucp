package com.zyyu.ucp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 读取配置文件(application.yml)属性
 */
@Configuration
public class UcpConfig {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${server.servlet.context-path}")
    private String rootPath;

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public String getRootPath(){
        return rootPath;
    }
}
