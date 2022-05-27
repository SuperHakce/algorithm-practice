package com.superhakce.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *给你一个由n个整数组成的数组nums ，和一个目标值target。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Super
 */
public class FourSum {

    /**
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(Objects.isNull(nums) || nums.length < 4){return ans;}
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i ++){
            if(i > 0 && nums[i - 1] == nums[i]){continue;}
            for(int j = i + 1; j < nums.length - 2; j ++){
                if(j > 1 && j > i + 1 && nums[j - 1] == nums[j]){continue;}
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[left] + nums[right] + nums[j] + nums[i] == target){
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        left ++;
                        right --;
                        ans.add(list);
                        while (left < right && nums[right] == nums[right + 1]){right --;}
                        while (left < right && nums[left] == nums[left - 1]){left ++;}
                    }else if(nums[left] + nums[right] + nums[i] + nums[j] < target){left ++;}
                    else{right --;}
                }
            }
        }
        return ans;
    }

}
