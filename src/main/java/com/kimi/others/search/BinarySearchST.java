package com.kimi.others.search;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/3/2 10:38
 * @Author Feng Yalong
 */
public class BinarySearchST<K extends Comparable<K>, V> {
    private K[] keys;
    private V[] values;
    private int n;

    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    public int size() {
        return n;
    }

    public V get(K key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = n; j < i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    public void delete(K key) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            for (int j = i + 1; j < n; j++) {
                keys[i] = keys[j];
                values[i] = values[j];
            }
        }
    }

    private int rank(K key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) >>> 1;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    private boolean isEmpty() {
        return n == 0;
    }

    public K min() {
        return keys[0];
    }

    public K max() {
        return keys[n - 1];
    }

    public K select(int k) {
        return keys[k];
    }

    public K ceiling(K key) {
        int i = rank(key);
        return keys[i];
    }

}
