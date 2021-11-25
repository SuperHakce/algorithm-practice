package com.superhakce.leetcode;

/**
 * 可怜的小猪
 * @author Super
 */
public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        for(int i = 0; ; i ++){
            if(Math.pow((minutesToTest / minutesToDie + 1) ,i) >= buckets){
                return i;
            }
        }
    }

}
