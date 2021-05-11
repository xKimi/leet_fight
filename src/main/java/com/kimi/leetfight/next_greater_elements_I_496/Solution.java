package com.kimi.leetfight.next_greater_elements_I_496;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/5/11 15:30
 */
public class Solution {

    // 时间复杂度O(MN)，空间复杂度O(1)，不包含保存结果的数组
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int length1 = nums1.length;
        int length2 = nums2.length;
        for (int i = 0; i < length1; i++) {
            int j = 0;
            while (j < length2 && nums2[j] != nums1[i]) {
                j++;
            }
            j++;
            while (j < length2 && nums2[j] < nums1[i]) {
                j++;
            }
            if (j == length2) {
                result[i] = -1;
                continue;
            }
            result[i] = nums2[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        Arrays.stream(result).forEach(System.out::println);
    }
}
