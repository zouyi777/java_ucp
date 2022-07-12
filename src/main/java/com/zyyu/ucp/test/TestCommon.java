package com.zyyu.ucp.test;

import org.apache.commons.lang3.StringUtils;

public class TestCommon {

    private String userName;
    private int age;

    public static void main(String[] args) {
//        System.out.println(12/3*2);
//        System.out.println(StringUtils.isNotBlank("  "));
//        System.out.println(StringUtils.isNotEmpty(null));
//        System.out.println(StringUtils.isNotEmpty("  "));

        TestCommon testCommon = new TestCommon("zouyi",30);
        System.out.println(testCommon.toString());
    }

    public TestCommon(String userName,int age){
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestCommon{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
