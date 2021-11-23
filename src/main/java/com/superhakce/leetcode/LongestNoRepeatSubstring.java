package com.superhakce.leetcode;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 * @author Super
 */
public class LongestNoRepeatSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(null == s || "".equals(s)){
            return 0;
        }
        int head = 0, tail = 0;
        int maxLength = 1, nowLength = 1;
        char[] old = s.toCharArray();
        while(tail + 1 < old.length){
            for(int i = head; i <= tail; i ++){
                if(old[tail + 1] == old[i]){
                    nowLength = tail - head + 1;
                    head = i + 1;
                    if(nowLength > maxLength){
                        maxLength = nowLength;
                    }
                    break;
                }
            }
            tail ++;
        }
        if((nowLength = tail - head + 1) > maxLength){
            maxLength = nowLength;
        }
        return maxLength;
    }

}
