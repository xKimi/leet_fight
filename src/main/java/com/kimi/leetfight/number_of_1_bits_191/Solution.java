package com.kimi.leetfight.number_of_1_bits_191;

/**
 * Description:
 * Copyright @2021 xKimi.inc
 *
 * @author Kimi
 * @date 2021/7/20
 */
public class Solution {

    // 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

    public static int hammingWeight(int n) {
        int count = 0;

//        for (int i = 0; i < 32; i++) {
//            if ((n & 1 << i) != 0) {
//                count++;
//            }
//        }
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
