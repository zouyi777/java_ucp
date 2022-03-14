package com.zyyu.ucp.test;

import com.zyyu.ucp.utils.MD5Util;
import com.zyyu.ucp.utils.StringUcpUtil;

import static com.zyyu.ucp.test.TestKotlinClassKt.CATGORY_EDOC;

public class TestString {

    public static void main(String[] args) {
        String str = "  啊   /n啊  哈,哈  ";
        System.out.println(StringUcpUtil.getPureString(str));
        System.out.println(MD5Util.getMD5("清风以北过南巷南巷故人不知归"));

    }
}
