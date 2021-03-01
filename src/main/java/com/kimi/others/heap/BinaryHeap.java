package com.kimi.others.heap;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/3/1 15:37
 * @Author Feng Yalong
 */
public class BinaryHeap {

    private static int[] pq = new int[]{};

    public static boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    public static void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private static void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private static void sink(int k) {
        while (2 * k <= pq.length) {
            int j = 2 * k;
            if (j < pq.length && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
}
