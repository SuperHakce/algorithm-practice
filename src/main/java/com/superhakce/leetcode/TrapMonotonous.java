package com.superhakce.leetcode;

/**
 * 解法二
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class TrapMonotonous {

    public int trap(int[] height) {
        int sum = 0;
        int startIndex = 0;
        while (startIndex < height.length){
            int targetIndex = 0;
            int target = 0;
            for(int i = startIndex + 1; i < height.length; i ++){
                if(height[i] >= height[startIndex]){
                    targetIndex = i;
                    target = height[i];
                    break;
                }
                if(height[i] > target){
                    targetIndex = i;
                    target = height[i];
                }
            }
            int block = 0;
            for(int i = startIndex + 1; i < targetIndex; i ++){
                block += height[i];
            }
            if(targetIndex - startIndex - 1 > 0){
                sum += Math.min(height[startIndex], target) * (targetIndex - startIndex - 1) - block;
            }
            if(targetIndex == 0){
                startIndex ++;
            } else {
                startIndex = targetIndex;
            }

        }
        return sum;
    }

}
