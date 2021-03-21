package com.kimi.others.lru;

import java.util.HashMap;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/3/18 16:19
 */
public class LRUCache {

    HashMap<Integer, Node> map;

    DoubleList cache;

    private int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    class Node {
        public int key, val;
        public Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {

        private Node first;
        private Node last;

        public DoubleList() {
            this.first = null;
            this.last = null;
        }

        public void addFirst(Node x) {
            if (first == null) {
                last = x;
            } else {
                // 现在的first节点往下移动
                first.prev = x;
                x.next = first;
            }
            first = x;
        }

        public void remove(Node x) {
            Node current = first;
            while (current.key != x.key) {
                if (current.next == null) {
                    return;
                }
                current = current.next;
            }
            if (first.key == x.key) {
                first = first.next;
            } else {
                current.prev.next = current.next;
            }
        }

        public Node removeLast() {
            Node temp = last;
            if (first == null) {
                return null;
            }
            if (first.next == null) {
                first = null;
                last = null;
            } else {
                last.prev.next = null;
                last = temp.prev;
            }
            return temp;
        }

        public int size() {
            return map.size();
        }
    }

    int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    private void put(int key, int val) {
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (cap == map.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}
