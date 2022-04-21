package com.superhakce;

import com.superhakce.leetcode.ThreeSum;

import java.util.List;

public class Main {

    //输入：nums = [-1,0,1,2,-1,-4]
    //输出：[[-1,-1,2],[-1,0,1]]
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> resultList = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println("size = " + resultList.size() + " time = " + (System.currentTimeMillis() - startTime));
    }

}
