package com.superhakce.leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 -2^32 ~ 2^32-1 ，就返回 0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Super
 */
public class NumberReverse {

    public int reverse(int x) {
        // 特殊情况处理
        if(x < Integer.MIN_VALUE || x > Integer.MAX_VALUE || x == 0){
            return 0;
        }
        // 保留原数据的符号
        int flag = x > 0 ? 1 : -1;
        // 转化为正数
        if(x < 0){
            x *= -1;
        }
        int result = 0;
        // 反转
        while(x > 0){
            int a = x % 10;
            if((((Integer.MAX_VALUE - a) / 10 < result) && flag > 0)
                    || (((Integer.MIN_VALUE + a) / -10 < result) && flag < 0)){
                return 0;
            }
            result *= 10;
            result += a;
            x = x / 10;
        }
        return result * flag;
    }

}
