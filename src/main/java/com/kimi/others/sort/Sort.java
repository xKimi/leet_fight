package com.kimi.others.sort;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/2/24 18:59
 * @Author Feng Yalong
 */
public class Sort {

    public static void selectionSort(Comparable[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            exch(nums, i, min);
        }
    }

    public static void insertionSort(Comparable[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            System.out.println("current index i = " + i);
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                System.out.println("current index j = " + j);
                exch(nums, j, j - 1);
            }
        }
    }

    public static void hillSort(Comparable[] nums) {
        int n = nums.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j > h && less(nums[j], nums[j - h]) ; j -=h) {
                    exch(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static void exch(Comparable[] nums, int i, int j) {
        System.out.println("exchange element " + nums[i] + " and " + nums[j]);
        Comparable temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static boolean less(Comparable num, Comparable num1) {
        return num.compareTo(num1) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 1, 5, 7, 11, 9, 2, 10};
//        selectionSort(nums);
        insertionSort(nums);
        if (!isSorted(nums)) {
            System.out.println("排序未完成");
        }
        show(nums);
    }
}
