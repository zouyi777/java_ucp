package com.zyyu.ucp.test.algorithm;

/**
 * 两数之和：给定一个整数数组 nums 和一个整数目标值 target ,请在该数组中找出和等于目标值的那两个整数，并返回他们的数组下标。
 * 例如：输入 nums = [2,7,11,15], target = 9; 输出 [0,1]
 */
public class TestSumOfInteger {

    public static void main(String[] args) {

        int[] nums = {2,7,2,11,15,1,8,5,4,3,6,2,3,4,1};
        int target = 9;

        long start = System.currentTimeMillis();
        System.out.println(simple(nums,target));
        long end = System.currentTimeMillis();
        System.out.println("花费时间="+ (end - start));
    }

    private static String simple(int[] nums,int target){
        String indexs = "";
       for(int i=0;i< nums.length-1;i++){
           for(int j=i+1;j<nums.length;j++){
               if((nums[i] + nums[j]) == target){
                   indexs += "["+nums[i]+","+nums[j]+"],";
               }
           }
       }
       return indexs;
    }
}
