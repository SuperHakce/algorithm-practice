package com.superhakce.leetcode;

/**
 * @author Super
 *
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(null == strs){
            return null;
        }
        if(strs.length == 1){
            return strs[0];
        }
        char[] result = strs[0].toCharArray();
        for(int i = 1; i < strs.length; i ++){
            char[] a = strs[i].toCharArray();
            if(a.length <= 0){
                for(int z = 0; z < result.length; z ++){
                    result[z] = '\u0000';
                }
            }
            for(int j = 0; j < a.length; j ++){
                if(result.length > a.length){
                    for(int x = a.length; x < result.length; x ++){
                        if(result[x] < 'a' || result[x] > 'z'){
                            break;
                        }
                        result[x] = '\u0000';
                    }
                }
                if(j >= result.length || result[j] < 'a' || result[j] > 'z'){
                    break;
                }
                if(result[j] != a[j]){
                    for(int k = j; k < result.length; k ++){
                        result[k] = '\u0000';
                    }
                    break;
                }
            }
        }
        return new String(result).trim();
    }

}
