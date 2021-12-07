package com.superhakce.leetcode;

/**
 * Z 字形变换
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if(null == s || "".equals(s) || numRows < 0){
            return s;
        }
        // 原始数据
        char[] old = s.toCharArray();
        // 结果数据
        char[] result = new char[s.length()];
        // 每行数据数组
        int[] lengthArray = new int[numRows + 1];
        // V 字形容量
        int vCapacity = numRows * 2 - 2;
        if(vCapacity == 0){
            return s;
        }
        // V 字形数量
        int vNumber = s.length() / (vCapacity);
        // 最后一个非完整 V 字形的字母数
        int lessNumber = s.length() - vNumber * (vCapacity);
        // 计算每行多少数据，lengthArray[1] = 100；表示第一行有100个数据
        for(int i = 1; i <= numRows; i ++){
            if(i == 1 || i == numRows){
                lengthArray[i] = vNumber;
            }else{
                lengthArray[i] = vNumber * 2;
            }
        }
        for(int i = 1; i <= lessNumber; i ++){
            if(i <= numRows){
                lengthArray[i] = lengthArray[i] + 1;
            }else{
                int tmp = numRows - (i % numRows);
                lengthArray[tmp] = lengthArray[tmp] + 1;
            }
        }
        // 每行从第几个开始
        int index = lengthArray[1];
        lengthArray[1] = 0;
        for(int i = 2; i <= numRows; i ++){
            int tmp = lengthArray[i];
            lengthArray[i] = index;
            index += tmp;
        }
        for(int i = 0; i < s.length(); i ++){
            int tmp = i % vCapacity;
            if(tmp < numRows){
                result[lengthArray[tmp + 1]] = old[i];
                lengthArray[tmp + 1] = lengthArray[tmp + 1] + 1;
            }else{
                int a = numRows - (tmp % numRows) - 1;
                result[lengthArray[a]] = old[i];
                lengthArray[a] = lengthArray[a] + 1;
            }
        }
        return new String(result);
    }
}
