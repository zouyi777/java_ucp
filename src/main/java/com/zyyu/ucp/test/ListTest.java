package com.zyyu.ucp.test;

import com.zyyu.ucp.vo.UserVo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        System.out.println("----------------ArrayList------------------");
        List<String> str = new ArrayList<>();
        str.add("111");
        str.add("222");
        str.add("333");
        str.add("444");
        str.add("555");

        System.out.println(str);

//        str.remove("222");
        str.add(3,"aaa");

        System.out.println(str);

        System.out.println("----------------LinkedList------------------");
        LinkedList<String> str1 = new LinkedList<>();

        str1.add("111");
        str1.add("222");
        str1.add("333");
        str1.add("444");
        str1.add("555");

        System.out.println(str1);

//        str1.remove("222");
//        str1.add(3,"aaa");
        String el = str1.pop();
//        String el = str1.peek();
//        String el = str1.poll();
        System.out.println(el);
//        str1.poll();
//        str1.push("aaa");
//        str1.offer("ccc");

        System.out.println(str1);
//
//        str1.pop();
//
//        System.out.println(str1);
    }
}
