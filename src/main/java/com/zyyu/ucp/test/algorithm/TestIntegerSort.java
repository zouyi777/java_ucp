package com.zyyu.ucp.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestIntegerSort {

    public static void main(String[] args) {

        //数组
        int[] nums = {1,4,2,3};
        //方式一
        Arrays.sort(nums);
        String sortNumsStr = "[";
        for(int i = 0; i < nums.length; i++){
            sortNumsStr += nums[i]+" ";
        }
        System.out.println(sortNumsStr+"]");

        //List
        List<Integer> array2 = new ArrayList<>();
        array2.add(2);
        array2.add(1);
        array2.add(2);
        array2.add(3);
        array2.add(0);
        array2.add(3);
        //方式一
        Collections.sort(array2);
        System.out.println(array2.toString());
    }
}
