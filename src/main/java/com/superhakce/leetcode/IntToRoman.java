package com.superhakce.leetcode;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * 1 <= num <= 3999
 * https://leetcode-cn.com/problems/integer-to-roman/
 * @author Super
 */
public class IntToRoman {

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder(8);
        while(num > 0){
            if(num >= 1000){
                num = common(stringBuilder, num, 1000, "M");
            }
            if(num >= 900){
                num = special(stringBuilder, num, 900, "CM");
            }
            if(num >= 500){
                num = common(stringBuilder, num, 500, "D");
            }
            if(num >= 400){
                num = special(stringBuilder, num, 400, "CD");
            }
            if(num >= 100){
                num = common(stringBuilder, num, 100, "C");
            }
            if(num >= 90){
                num = special(stringBuilder, num, 90, "XC");
            }
            if(num >= 50){
                num = common(stringBuilder, num, 50, "L");
            }
            if(num >= 40){
                num = special(stringBuilder, num, 40, "XL");
            }
            if(num >= 10){
                num = common(stringBuilder, num, 10, "X");
            }
            if(num >= 9){
                num = special(stringBuilder, num, 9, "IX");
            }
            if(num >= 5){
                num = common(stringBuilder, num, 5, "V");
            }
            if(num >= 4){
                num = special(stringBuilder, num, 4, "IV");
            }
            if(num >= 1){
                num = common(stringBuilder, num, 1, "I");
            }
        }
        return stringBuilder.toString();
    }

    private Integer common(StringBuilder stringBuilder, Integer num, Integer base, String code){
        int a = num / base;
        num = num % base;
        for (int i = 0; i < a; i ++) {
            stringBuilder.append(code);
        }
        return num;
    }

    private Integer special(StringBuilder stringBuilder, Integer num, Integer base, String code){
        num = num - base;
        stringBuilder.append(code);
        return num;
    }

}
