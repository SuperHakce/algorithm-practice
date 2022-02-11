package com.superhakce.leetcode;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    public int trap(int[] height) {
        int sum = trapIteration(height, 0, height.length - 1);
        return sum;
    }

    private int trapIteration(int[] height, int startIndex, int lastIndex) {
        int sum = 0;
        if(lastIndex <= startIndex + 1){
            return sum;
        }
        int highest = 0;
        int highestIndex = 0;
        int secondHigh = 0;
        int secondHighIndex = 0;
        for(int i = startIndex; i <= lastIndex; i ++){
            if(height[i] > highest){
                if(highest > secondHigh){
                    secondHigh = highest;
                    secondHighIndex = highestIndex;
                }
                highest = height[i];
                highestIndex = i;
            }else if(height[i] > secondHigh){
                secondHigh = height[i];
                secondHighIndex = i;
            }
        }
        int firstIndex = Math.min(highestIndex, secondHighIndex);
        int secondIndex = Math.max(highestIndex, secondHighIndex);
        int maxHigh = Math.min(highest, secondHigh);
        int block = 0;
        for(int i = firstIndex + 1; i < secondIndex; i ++){
            block += height[i];
        }
        if(secondIndex - firstIndex - 1 > 0){
            sum += maxHigh * (secondIndex - firstIndex - 1) - block;
        }
        sum += trapIteration(height, startIndex, firstIndex);
        sum += trapIteration(height, secondIndex, lastIndex);
        return sum;
    }

}
