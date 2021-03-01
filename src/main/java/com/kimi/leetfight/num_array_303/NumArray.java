package com.kimi.leetfight.num_array_303;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/3/1 10:36
 * @Author Feng Yalong
 */
public class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 6, 7, 8, 9};
        NumArray obj = new NumArray(nums);
        int result = obj.sumRange(2, 4);
        System.out.println(result);
    }
}
