package com.superhakce.leetcode;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Super
 */
public class IsMatch {

    // 动态规划：初始条件、状态表达式、状态转移公式（最优子结构） dp[c][d] c - 1, d - 1 匹配情况，true 匹配成功，false 匹配失败
    public boolean isMatch(String s, String p) {
        if(s == null && p == null){
            return true;
        }
        if(s == null || p == null){
            return false;
        }
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean[][]dp = new boolean[m][n];
        dp[0][0] = true;
        for(int j = 2; j < n; j ++){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j - 2];
            }
        }
        int i,j;
        for(int c = 1; c < m; c ++){
            i = c - 1;
            for(int d = 1; d < n; d ++){
                j = d - 1;
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    dp[c][d] = dp[c - 1][d - 1];
                }else if(p.charAt(j) == '*'){
                    if(s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                        dp[c][d] = dp[c - 1][d] | dp[c][d - 2];
                    }else {
                        dp[c][d] = dp[c][d - 2];
                    }
                }else {
                    dp[c][d] = false;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
