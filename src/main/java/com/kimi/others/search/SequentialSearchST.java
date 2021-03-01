package com.kimi.others.search;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/3/1 19:57
 * @Author Feng Yalong
 */
public class SequentialSearchST<K, V> {

    private Node first;
    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V get(K key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        // 未找到创建新节点
        first = new Node(key, value, first);
    }
}
