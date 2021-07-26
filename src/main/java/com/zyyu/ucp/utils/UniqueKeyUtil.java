package com.zyyu.ucp.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 自定义自然主键生成类
 * (不使用自增型代理主键)
 */
public class UniqueKeyUtil {
    private static final Log log = LogFactory.getLog(UniqueKeyUtil.class);
    /**
     * 生成不重复的11位字符串
     * 10进制转16进制
     * 高并发情况下可能会出现重名，所以需要使用synchronized关键词来修饰
     * @return
     */
    public static synchronized Long getUniqueKey() {
        long randomInteger = System.currentTimeMillis();
        // 睡眠1ms，避免出现重复的key
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            log.error("[UniqueKeyUtil]Thread.sleep() error, errMsg = {}", e);
        }
        return randomInteger;
    }
}
