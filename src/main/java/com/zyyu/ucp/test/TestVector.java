package com.zyyu.ucp.test;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class TestVector {

    public static void main(String[] args) {
        Vector<String> vector =new Vector();
        System.out.println("默认动态数组大小："+vector.capacity());

        //添加元素
        vector.add("1111");
        vector.add("2222");
        vector.add("3333");

        //输出全部元素
        System.out.println(vector);

        //输出某个角标的元素
        System.out.println("角标为2的元素："+vector.get(2));

        //移除某个元素
        vector.remove("2222");
        System.out.println(vector);

        /**
         * 遍历所有元素
         * Vector支持4种遍历方式建议使用下面的第二种去遍历Vector，因为效率问题。
         * 遍历Vector，使用索引的随机访问方式最快，使用迭代器最慢。
         */
        //1、第一种，通过迭代器遍历。即通过Iterator去遍历
        System.out.println("---迭代器遍历开始");
        Iterator<String> iterator = vector.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---迭代器遍历结束");

        //2、第二种，for循环，随机访问，通过索引值去遍历。由于Vector实现了RandomAccess接口，它支持通过索引值去随机访问元素。
        System.out.println("---for循环遍历开始");
        for(int i=0;i<vector.size();i++){
            System.out.println(vector.get(i));
        }
        System.out.println("---for循环遍历结束");

        //3、第三种，另一种for循环
        System.out.println("---另一种for循环遍历开始");
        for(String item:vector){
            System.out.println(item);
        }
        System.out.println("---另一种for循环遍历结束");

        //4、第四种，Enumeration遍历
        System.out.println("---Enumeration遍历开始");
        Enumeration enu = vector.elements();
        while (enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }
        System.out.println("---Enumeration遍历结束");
    }
}
