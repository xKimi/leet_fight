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

    public static void mergeSort(Comparable[] nums, int lo, int mid, int hi) {
        Comparable[] newNums = new Comparable[nums.length];
        int i = lo, j = mid + 1;
        for (int k = lo; k < hi; k++) {
            newNums[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = newNums[j++];
            } else if (j > hi) {
                nums[k] = newNums[i++];
            } else if (less(newNums[j], nums[j])) {
                nums[k] = newNums[j++];
            } else {
                nums[k] = newNums[i++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        mergeSort(a, lo, mid, hi);
    }

    /**
     * 自底向上的归并
     * @param a 排序前数组
     */
    public static void mergeFromBottom(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                mergeSort(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }

    public static void quickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    public static void quick3Sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
