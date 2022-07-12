package com.zyyu.ucp.test.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 两数之和：给定一个整数数组 nums 和一个整数目标值 target ,请在该数组中找出和等于目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能重复，你可以按任意顺序返回答案。
 * 例如：输入 nums = [2,7,11,15], target = 9; 输出 [0,1]
 */
public class TestSumOfInteger {

    public static void main(String[] args) {

        int[] nums = {2,7,11,4,6,21,13,16,5};
        int target = 10;

        long start = System.currentTimeMillis();
        System.out.println(simple(nums,target).toString());
        long end = System.currentTimeMillis();
        System.out.println("花费时间="+ (end - start));
    }

    /**
     * 方式一：通过和值计算，时间复杂度 O(n(1+n)/2)
     * @param nums
     * @param target
     * @return
     */
    private static List simple(int[] nums, int target){
        List<String> result = new ArrayList();
        int execTims = 0;
        for(int i=0;i< nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i] + nums[j]) == target){
                    String indexs = "["+i+","+j+"]";
                    result.add(indexs);
                }
                execTims++;
            }
        }
        System.out.println("执行次数="+execTims);
        return result;
    }

    /**
     * 方式二：通过差值计算，时间复杂度 O(2n)
     * @param nums
     * @param target
     * @return
     */
    public static List twoSum(int[] nums, int target) {
        List<String> result = new ArrayList();
        int execTims = 0;
        HashMap<Integer, Integer> map = new HashMap<> ();//创建一个HashMap对象
        for(int j = 0; j < nums.length; j++){
            int t = target - nums[j];
            if(map.containsKey(t) && map.get(t)!=j){//判断差值t是否被包含在map里面
                String indexs = "["+map.get(t)+","+j+"]";
                result.add(indexs);
            }
            map.put(nums[j],j);
            execTims++;
        }
        System.out.println("执行次数="+execTims);
        return result;
    }
}
