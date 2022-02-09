package com.superhakce.leetcode;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 41. 缺失的第一个正数
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums){
        int flag = nums.length + 1;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] < 0 || nums[i] > nums.length){
                nums[i] = 0;
            }
        }
        for(int i = 0; i < nums.length; i ++){
            int temp = nums[i] % flag;
            if(temp == 0){
                continue;
            }
            if(nums[temp - 1] <= nums.length){
                nums[temp - 1] += flag;
            }
        }
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] < flag){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
