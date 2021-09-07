package com.zyyu.ucp.vo;

public class SystemInfoVo {
     /**用户名*/
     private String userName;
     /**服务器计算机名*/
     private String computerName;
     /**ip地址*/
     private String serverIP;
     /**域名*/
     private String domain;
     /**端口*/
     private String localPort;
     /**Java的运行环境版本*/
     private String javaVersion;
     /**Java的运行环境供应商*/
     private String javaVendor;
     /**Java的安装路径*/
     private String javaHome;
     /**JVM可以使用的总内存*/
     private String javaTotalMemory;
     /**JVM可以使用的剩余内存*/
     private String javaFreeMemory;
     /**应用服务器*/
     private String appServer;
     /**数据库类型*/
     private String dbType;
     /**操作系统*/
     private String os;
     /**操作系统版本*/
     private String osVsersion;
     /**当前工作目录*/
     private String workDir;

     public String getUserName() {
          return userName;
     }

     public void setUserName(String userName) {
          this.userName = userName;
     }

     public String getComputerName() {
          return computerName;
     }

     public void setComputerName(String computerName) {
          this.computerName = computerName;
     }

     public String getServerIP() {
          return serverIP;
     }

     public void setServerIP(String serverIP) {
          this.serverIP = serverIP;
     }

     public String getDomain() {
          return domain;
     }

     public void setDomain(String domain) {
          this.domain = domain;
     }

     public String getLocalPort() {
          return localPort;
     }

     public void setLocalPort(String localPort) {
          this.localPort = localPort;
     }

     public String getJavaVersion() {
          return javaVersion;
     }

     public void setJavaVersion(String javaVersion) {
          this.javaVersion = javaVersion;
     }

     public String getJavaVendor() {
          return javaVendor;
     }

     public void setJavaVendor(String javaVendor) {
          this.javaVendor = javaVendor;
     }

     public String getJavaHome() {
          return javaHome;
     }

     public void setJavaHome(String javaHome) {
          this.javaHome = javaHome;
     }
     public String getJavaTotalMemory() {
          return javaTotalMemory;
     }

     public void setJavaTotalMemory(String javaTotalMemory) {
          this.javaTotalMemory = javaTotalMemory;
     }

     public String getJavaFreeMemory() {
          return javaFreeMemory;
     }

     public void setJavaFreeMemory(String javaFreeMemory) {
          this.javaFreeMemory = javaFreeMemory;
     }
     public String getAppServer() {
          return appServer;
     }

     public void setAppServer(String appServer) {
          this.appServer = appServer;
     }

     public String getDbType() {
          return dbType;
     }

     public void setDbType(String dbType) {
          this.dbType = dbType;
     }

     public String getOs() {
          return os;
     }

     public void setOs(String os) {
          this.os = os;
     }
     public String getOsVsersion() {
          return osVsersion;
     }

     public void setOsVsersion(String osVsersion) {
          this.osVsersion = osVsersion;
     }
     public String getWorkDir() {
          return workDir;
     }

     public void setWorkDir(String workDir) {
          this.workDir = workDir;
     }
}
