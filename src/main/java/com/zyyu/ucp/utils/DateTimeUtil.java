package com.zyyu.ucp.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期、时间工具类
 */
public class DateTimeUtil {
    private static final Log log = LogFactory.getLog(DateTimeUtil.class);

    /**
     * 获取系统当前日期时间：有时分秒，没有毫秒
     * @return
     */
    public static Timestamp getCurDateTime(){
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(dt);
        Timestamp buydate = Timestamp.valueOf(nowTime);
        return buydate;
    }


}
