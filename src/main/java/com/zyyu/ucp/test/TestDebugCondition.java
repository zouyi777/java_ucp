package com.zyyu.ucp.test;

/**
 * 测试调试条件
 */
public class TestDebugCondition {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        for(int i=0;i<arr.length;i++){
            if(arr[i]==5){
                System.out.println(i);
            }
        }

    }
}
