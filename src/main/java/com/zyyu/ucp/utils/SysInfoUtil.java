package com.zyyu.ucp.utils;


import com.zyyu.ucp.vo.SystemInfoVo;
import org.apache.catalina.util.ServerInfo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Properties;

public class SysInfoUtil {

    /**
     * 系统属性
     */
    public static SystemInfoVo property(){
        SystemInfoVo systemInfoVo = new SystemInfoVo();

        Map<String, String> map = System.getenv();
        systemInfoVo.setUserName(map.get("USERNAME"));
        systemInfoVo.setComputerName(map.get("COMPUTERNAME"));
        systemInfoVo.setDomain(map.get("USERDOMAIN"));

        Properties props = System.getProperties();
        systemInfoVo.setJavaVersion(props.getProperty("java.version"));
        systemInfoVo.setJavaVendor(props.getProperty("java.vendor"));
        systemInfoVo.setJavaHome(props.getProperty("java.home"));
        systemInfoVo.setOs(props.getProperty("os.name"));
        systemInfoVo.setOsVsersion(props.getProperty("os.version"));
        systemInfoVo.setWorkDir(props.getProperty("user.dir"));

        Runtime r = Runtime.getRuntime();
        systemInfoVo.setJavaTotalMemory(r.totalMemory() / 1024 / 1024 + "M");
        systemInfoVo.setJavaFreeMemory(r.freeMemory()/ 1024 / 1024 + "M");

        systemInfoVo.setAppServer(ServerInfo.getServerInfo());
        systemInfoVo.setDbType("mySql");
        return systemInfoVo;
    }

    public static void getDbInfo(){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection conn = DriverManager.getConnection(url_nanjing, user_nanjing, password_nanjing);

        DatabaseMetaData metaData = (DatabaseMetaData) conn.getMetaData();

        String version = metaData.getDatabaseProductVersion();//得到数据库版本信息
    }
}
