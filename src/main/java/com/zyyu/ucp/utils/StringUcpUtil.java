package com.zyyu.ucp.utils;

public class StringUcpUtil {

    /**
     * 过滤标点符号
     * @param src
     * @return
     */
    public static String filterMark(String src){
        return src.replaceAll("[\\pP‘’“”]", "");
    }

    /**
     * 去掉空格
     * @param src
     * @return
     */
    public static String filterBlank(String src){
        return src.replaceAll("\\s*", "");
    }

    /**
     * 获取纯净的字符串（没有空格，没有标点符号）
     * @param src
     * @return
     */
    public static String getPureString(String src){
        src = filterBlank(src);
        src = filterMark(src);
        return src;
    }
}
