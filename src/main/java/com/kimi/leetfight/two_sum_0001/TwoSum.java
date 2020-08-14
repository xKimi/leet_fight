package com.kimi.leetfight.two_sum_0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/8/14 17:28
 * @Author Feng Yalong
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int minusResult = target - nums[i];
            if (map.containsKey(minusResult)) {
                return new int[] {map.get(minusResult), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no result");
    }
}
