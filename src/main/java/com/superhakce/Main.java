package com.superhakce;

import com.superhakce.leetcode.FindTwoSum;

public class Main {

    public static void main(String[] args) {
        FindTwoSum findTwoSum = new FindTwoSum();
        int[] a = {2, 5, 5, 11};
        int[] r = findTwoSum.twoSum(a, 10);
        System.out.println(r[0] + " : " + r[1]);
    }

}
