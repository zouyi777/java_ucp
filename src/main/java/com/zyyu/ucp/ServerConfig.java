package com.zyyu.ucp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取项目的IP和端口
 */
@Component
public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {

    @Autowired
    UcpConfig ucpConfig;

    private int serverPort;

    /**
     * 获取主机地址
     * @return
     */
    public String getHost() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return address.getHostAddress();
    }

    /**
     * 获取端口
     * @return
     */
    public int getServerPort() {
        return serverPort;
    }

    /**
     * 获取主机加端口
     * @return
     */
    public String getHostPort() {
        return getHost()+":"+this.serverPort;
    }

    /**
     * 获取请求根路径
     * @return
     */
    public String getBaseUrl(){
        return "http://"+getHostPort()+ucpConfig.getRootPath();
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        serverPort = event.getWebServer().getPort();
    }
}
