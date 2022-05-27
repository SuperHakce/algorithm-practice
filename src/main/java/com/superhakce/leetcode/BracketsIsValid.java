package com.superhakce.leetcode;

import java.util.Stack;

/**
 *给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Super
 */
public class BracketsIsValid {

    /**
     * 输入：s = "()[]{}"
     * 输出：true
     * 输入：s = "(]"
     * 输出：false
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] source = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : source) {
            if(stack.empty()){
                stack.push(c);
            }else {
                Character last = stack.peek();
                if((')' == c && '(' == last)
                        || (']' == c && '[' == last)
                        || ('}' == c && '{' == last)){
                    stack.pop();
                }else if(')' == c
                        || ']' == c
                        || '}' == c){
                    return false;
                }else {
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }

}
