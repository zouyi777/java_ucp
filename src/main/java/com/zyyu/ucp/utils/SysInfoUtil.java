package com.zyyu.ucp.utils;


import com.zyyu.ucp.vo.SystemInfoVo;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
        try {
            InetAddress addr = InetAddress.getLocalHost();
            systemInfoVo.setServerIP(addr.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        systemInfoVo.setLocalPort(getLocalPort());

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

        systemInfoVo.setAppServer("Tomcat");
        systemInfoVo.setDbType("mySql");
        return systemInfoVo;
    }

    /**
     * @return
     * 获取当前机器的端口号
     */
    public static String getLocalPort(){
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            Set<ObjectName>  objectNames  = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
            Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
            if(objectNames!=null && objectNames.size()>0){
                String port = objectNames.iterator().next().getKeyProperty("port");
                return port;
            }
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        return null;

    }
}
