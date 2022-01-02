package com.zyyu.ucp.utils;

import com.zyyu.ucp.security.WebConfig;

/**
 * 文件下载路径处理工具类
 */
public class FilePathUtil {

    private static final String ROOT_PATH = "/ucp";

    public static String getImageWholePath(String host,String path){
        String wholePath = host+ROOT_PATH + WebConfig.STATIC_RES_ROOT_PATH+"/"+ FileHandleUtil.imageDir+"/"+path;
        return wholePath;
    }
}
