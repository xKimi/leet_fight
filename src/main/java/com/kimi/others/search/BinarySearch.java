package com.kimi.others.search;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/2/23 17:02
 * @Author Feng Yalong
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = (low + high) >>> 1;
            if (key == nums[middle]) {
                return middle;
            } else if (key < nums[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {33, 17, 6, 5, 3, 11, 4, 8, 9, 16};
        System.out.println(binarySearch(nums, 6));
    }
}
