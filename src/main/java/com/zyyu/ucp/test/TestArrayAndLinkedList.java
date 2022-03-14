package com.zyyu.ucp.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestArrayAndLinkedList {

    public static void main(String[] args) {

        System.out.println("----------------ArrayList------------------");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("111");
        arrayList.add("222");
        arrayList.add("333");
        arrayList.add("444");
        arrayList.add("555");

        System.out.println(arrayList);

//        arrayList.remove("222");
        arrayList.add(3,"aaa");

        System.out.println(arrayList);

        System.out.println("----------------LinkedList------------------");
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        linkedList.add("444");
        linkedList.add("555");

        System.out.println(linkedList);

//        linkedList.remove("222");
//        linkedList.add(3,"aaa");
        String el = linkedList.pop();
//        String el = linkedList.peek();
//        String el = linkedList.poll();
        System.out.println(el);
//        linkedList.poll();
//        linkedList.push("aaa");
//        linkedList.offer("ccc");

        System.out.println(linkedList);
//
//        linkedList.pop();
//
//        System.out.println(linkedList);
    }
}
