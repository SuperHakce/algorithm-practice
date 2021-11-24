package com.superhakce.leetcode;

/**
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数
 * @author Super
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        int sum = nums1.length + nums2.length;
        if(sum == 0){
            return result;
        }
        if(sum == 1){
            return nums1.length > 0 ? nums1[0] : nums2[0];
        }
        boolean isEven = sum % 2 == 0;
        int index = (sum + 2) / 2;
        if(isEven){
            index --;
        }
        int i = 0, j = 0;
        while(i < nums1.length || j < nums2.length){
            if(i >= nums1.length){
                if(i + j + 1 == index){
                    result = nums2[j];
                    if(isEven && j + 1 < nums2.length){
                        result += nums2[j + 1];
                        result /= 2;
                    }
                    break;
                }
                j ++;
            } else if(j >= nums2.length){
                if(i + j + 1 == index){
                    result = nums1[i];
                    if(isEven && i + 1 < nums1.length){
                        result += nums1[i + 1];
                        result /= 2;
                    }
                    break;
                }
                i ++;
            } else {
                int min = Integer.MAX_VALUE;
                if(nums1[i] <= nums2[j]){
                    if(i + j + 1 == index){
                        result = nums1[i];
                        if(isEven){
                            min = Integer.min(min, nums2[j]);
                            if(i + 1 < nums1.length){
                                min = Integer.min(min, nums1[i + 1]);
                            }
                            result += min;
                            result /= 2;
                        }
                        break;
                    }
                    i ++;
                }else{
                    if(i + j + 1 == index){
                        result = nums2[j];
                        if(isEven){
                            min = Integer.min(min, nums1[i]);
                            if(j + 1 < nums2.length){
                                min = Integer.min(min, nums2[j + 1]);
                            }
                            result += min;
                            result /= 2;
                        }
                    }
                    j ++;
                }
            }
        }
        return result;
    }

}
