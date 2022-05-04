package com.superhakce.leetcode;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Super
 */
public class ThreeSumClosest {

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int threeSumClosestDoubleItem(int[] nums, int target) {
        int difference = Integer.MAX_VALUE;
        int result = 0;
        if(nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i ++){
            if(i > 0 && nums[i - 1] == nums[i]){continue;}
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                int var = nums[left] + nums[right] + nums[i];
                if(Math.abs(var - target) < difference){
                    result = var;
                    difference = Math.abs(var - target);
                    if(difference == 0){
                        return result;
                    }
                    // TODO 为什么这里不可以，需要再思考思考
                    // while (left < right && nums[left] == nums[left + 1]){left ++;}
                    // while (left < right && nums[right] == nums[right - 1]){right --;}
                }
                if(var - target > 0){
                    right --;
                }else {
                    left ++;
                }
            }
        }
        return result;
    }

}
