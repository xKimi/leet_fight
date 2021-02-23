package com.kimi.leetfight.fib;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/2/22 11:17
 * @Author Feng Yalong
 */
public class Solution {

    private static int fib(int n) {
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int fibUsingLessSpace(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev = 1, current = 1;
        for (int i = 3; i <= n ; i++) {
            int sum = prev + current;
            prev = current;
            current = sum;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(fib(20));
        System.out.println(fibUsingLessSpace(20));
    }
}
