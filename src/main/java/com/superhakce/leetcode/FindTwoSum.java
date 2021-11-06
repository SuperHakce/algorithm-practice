package com.superhakce.leetcode;

/**
 * LeetCode 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * n log n 解法：先排序，然后二分查找，如果没用找到目标值，则继续找下一个，直到该元素超过了target的二分之一为止。
 */
public class FindTwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] originResult = new int[2];
        int[] origin = nums.clone();
        quickSort(nums);
        for (int i = 0; i < nums.length; i ++){
            if(nums[i] * 2 > target){
                break;
            }else{
                int targetIndex = targetIndex(nums, i, nums.length - 1,target - nums[i]);
                if(targetIndex >= 0){
                    result[0] = i;
                    result[1] = targetIndex;
                    break;
                }
            }
        }
        int a= 0, b = 0;
        for(int i = 0; i < origin.length; i ++){
            if(origin[i] == nums[result[0]] && a != 1){
                originResult[0] = i;
                a = 1;
                continue;
            }
            if(origin[i] == nums[result[1]] && b != 1){
                originResult[1] = i;
                b = 1;
                continue;
            }
        }
        return originResult;
    }

    private int targetIndex(int[] nums, int left, int right, int otherTarget){
        if(left > right){
            return -1;
        }
        if(right - left <= 1){
            if(nums[left] == otherTarget){
                return left;
            }else if(nums[right] == otherTarget){
                return right;
            }else {
                return -1;
            }
        }
        int mid = (right + left) / 2;
        if(nums[mid] == otherTarget){
            return mid;
        }else if (left <= right){
            int l, r;
            if((l = targetIndex(nums, left, mid - 1, otherTarget)) >= 0){
                return l;
            }else if((r = targetIndex(nums, mid, right, otherTarget)) >= 0){
                return r;
            }
        }
        return -1;
    }

    /**
     * 快速排序
     * @param array
     */
    private void quickSort(int[] array) {
        int len;
        if(array == null || (len = array.length) == 0 || len == 1) {
            return ;
        }
        sort(array, 0, len - 1);
    }

    /**
     * 递归实现
     * @param array
     * @param left
     * @param right
     */
    private void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base 中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比 base 值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i >= j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

}
