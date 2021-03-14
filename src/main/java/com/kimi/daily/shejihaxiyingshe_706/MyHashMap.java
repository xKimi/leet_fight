package com.kimi.daily.shejihaxiyingshe_706;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created on 2021/3/14.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class MyHashMap {

    private class KVPair {
        private int key;
        private int value;

        private KVPair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int MASK = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[MASK];
        for (int i = 0; i < MASK; i++) {
            data[i] = new LinkedList<KVPair>();
        }
    }

    private int hash(int key) {
        return key % MASK;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        Iterator<KVPair> it = data[hash].iterator();
        while (it.hasNext()) {
            KVPair pair = it.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        data[hash].offerLast(new KVPair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        Iterator<KVPair> it = data[hash].iterator();
        while (it.hasNext()) {
            KVPair pair = it.next();
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        Iterator<KVPair> it = data[hash].iterator();
        while (it.hasNext()) {
            KVPair pair = it.next();
            if (pair.getKey() == key) {
                data[hash].remove(pair);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */