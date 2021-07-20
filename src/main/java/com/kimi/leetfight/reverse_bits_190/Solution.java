package com.kimi.leetfight.reverse_bits_190;

/**
 * Description:
 * Copyright @2021 xKimi.inc
 *
 * @author Kimi
 * @date 2021/7/20
 */
public class Solution {

    // 颠倒给定的 32 位无符号整数的二进制位。

    public static void main(String[] args) {
        int n = 487;
        System.out.println(Integer.toBinaryString(n));
        int reversedN = reverseBits(n);
        System.out.println(reversedN);
        System.out.println(Integer.toBinaryString(reversedN));
    }

    public static int reverseBits(int n) {
        if (n == 0) {
            return n;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n >>= 1;
        }
        return result;
    }
}
