package com.kimi.leetfight.majority_element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2021/2/17.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class Solution {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = map.getOrDefault(num, 0) + 1;
            map.put(num, value);
            if (value > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
}
