package com.superhakce.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第三次查找可以使用二分查找进行优化
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Super
 */
public class ThreeSum {

    /**
     * 第三次二分查找 O(n^2*logN)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().toArray();
        int length = nums.length;
        for(int i = 0; i < length; i ++){
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            int flag = Integer.MIN_VALUE;
            for(int j = i + 1; j < length; j ++){
                if(nums[i] + nums[j] > 0){
                    break;
                }
                // 二分查找
                int target = (nums[i] + nums[j]) * -1;
                if(j + 1 < length && target < nums[j + 1]){
                    continue;
                }
                if(target > nums[length - 1]){
                    continue;
                }
                int number = find(nums, target,j + 1, length - 1);
                if(number == flag){
                    continue;
                }
                flag = number;
                if(number > Integer.MIN_VALUE){
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(number);
                    resultList.add(list);
                }
            }
        }
        return resultList;
    }

    private int find(int[] nums, int target, int start, int end) {
        if(start > end){
            return Integer.MIN_VALUE;
        }
        if(start == end){
            if(target == nums[start]){
                return nums[start];
            }
            return Integer.MIN_VALUE;
        }
        int mid = (end + start) / 2;
        if(target == nums[mid]){
            return nums[mid];
        } else if(target < nums[mid]){
            return find(nums, target, start, mid - 1);
        }else {
            return find(nums, target, mid + 1, end);
        }
    }

    /**
     * O(n^3)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumViolence(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().toArray();
        for(int i = 0; i < nums.length; i ++){
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            int flag= Integer.MIN_VALUE;
            for(int j = i + 1; j < nums.length; j ++){
                if(nums[i] + nums[j] > 0){
                    break;
                }
                for(int k = j + 1; k < nums.length; k ++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        if(nums[k] != flag){
                            List<Integer> list = new ArrayList<>(3);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            resultList.add(list);
                            flag = nums[k];
                        }
                        break;
                    }
                    if(nums[i] + nums[j] + nums[k] > 0){
                        break;
                    }
                }
            }
        }
        return resultList;
    }

}
