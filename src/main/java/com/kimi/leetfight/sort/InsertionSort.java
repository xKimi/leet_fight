package com.kimi.leetfight.sort;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/8/26 18:51
 * @Author Feng Yalong
 */
public class InsertionSort {

    public void sort(int[] nums) {
        // 以数组左侧第一个元素为基准，从index=1处开始遍历
        for (int i = 1, j, current; i < nums.length; i++) {
            // 外围循环开始，把当前i指向的值用current保存
            current = nums[i];

            // 指针j内循环，和current值比较，若j所指向的值比current大，则该数右移一位
            for (j = i - 1; j >= 0 && nums[j] > current; j--) {
                nums[j + 1] = nums[j];
            }

            // 内循环结束， j+1所指向的位置就是current值插入的位置
            nums[j + 1] = current;
        }
    }
}
