package com.superhakce.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Super
 */
public class LetterCombinations {

    private static char[][] chars = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        List<String> strings = new ArrayList<>();
        if(null == digits || digits.length() <= 0){
            return strings;
        }
        recall(digits.toCharArray(), 0, strings);
        return strings;
    }

    private void recall(final char[] source, int i, List<String> strings) {
        if(i >= source.length - 1){
            split(source, i, strings);
        }else {
            split(source, i, strings);
            recall(source, i + 1, strings);
        }
    }

    private void split(final char[] source, int i, List<String> strings){
        if(strings.size() <= 0){
            for(int j = 0; j < chars[source[i] - 50].length; j ++){
                strings.add(String.valueOf(chars[source[i] - 50][j]));
            }
        }else {
            String[] strings1 = new String[]{};
            strings1 = strings.toArray(strings1);
            strings.clear();
            for (String string : strings1) {
                for(int j = 0; j < chars[source[i] - 50].length; j ++){
                    strings.add(string + chars[source[i] - 50][j]);
                }
            }
        }
    }

    public List<String> letterCombinationsOfficial(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else {
            char var = digits.charAt(index);
            String str = phoneMap.get(var);
            for (char c : str.toCharArray()) {
                combination.append(c);
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
