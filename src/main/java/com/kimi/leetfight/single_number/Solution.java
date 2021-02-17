package com.kimi.leetfight.single_number;

/**
 * Created on 2021/2/17.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class Solution {

    public static int simgleNumber(int[] nums) {
        int number = 0;
        for (int num : nums) {
            number ^= num;
        }
        return number;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(simgleNumber(nums));
    }
}
