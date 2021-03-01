package com.kimi.others.heap;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/3/1 16:09
 * @Author Feng Yalong
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public  boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public  void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private  void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private  void sink(int k) {
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

    public void insert(Key v) {
        pq[++n] = v;
        swim(n);
    }

    public Key deleteMax() {
        Key max = pq[1];
        exch(1, n--);
        pq[n+1] = null;
        sink(1);
        return max;
    }
}
