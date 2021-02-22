package com.kimi.leetfight.sort;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/8/26 18:14
 * @Author Feng Yalong
 */
public class BubbleSort {

    /**
     * 空间复杂度：O(1)
     * 时间复杂度：O(n * n)
     * 稳定算法
     * @param nums
     */
    public void sort(int[] nums) {
        // 记录是否进行交换
        boolean hasChange = true;

        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            // 开始循环前标记改为false
            hasChange = false;

            // 进行两两比较，比较次数为nums.length - 1 - i,如果当前数比下一个数大，进行交换，更新标记
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j + 1);
                    hasChange = true;
                }
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp;
        temp = nums[j];
        nums[j] = nums[j + 1];
        nums[j + 1] = temp;
    }
}
