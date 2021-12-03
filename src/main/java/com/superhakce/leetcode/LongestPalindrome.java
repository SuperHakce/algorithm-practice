package com.superhakce.leetcode;

/**
 * 最长回文子串
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        char filling = '#';
        int longest = 0, indexFirst = 0, indexSecond = 0;
        char[] chars = s.toCharArray();
        int fillArrayLength = chars.length * 2 + 1;
        char[] fillArray = new char[fillArrayLength];
        for(int i = 0, j = 0; i < fillArrayLength; i ++){
            if(i % 2 == 0){
                fillArray[i] = filling;
            }else {
                fillArray[i] = chars[j ++];
            }
        }
        int tmp = 0;
        for(int i = 0; i < fillArrayLength; i ++){
            if(tmp > longest){
                longest = tmp;
            }
            tmp = 0;
            for(int j = 0; ; j ++){
                if(i - j >= 0 && i + j < fillArrayLength && fillArray[i - j] == fillArray[i + j]){
                    tmp ++;
                }else{
                    if(tmp > longest){
                        longest = tmp;
                        indexFirst = i - j + 1;
                        indexSecond = i + j - 1;
                    }
                    break;
                }
            }
        }
        int j = -1;
        for(int i = indexFirst; i <= indexSecond; i ++){
            if(fillArray[i] == filling){
                continue;
            }
            chars[++ j] = fillArray[i];
        }
        return String.copyValueOf(chars, 0, j + 1);
    }

}
