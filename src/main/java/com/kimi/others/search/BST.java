package com.kimi.others.search;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/3/2 15:38
 * @Author Feng Yalong
 */
public class BST<K extends Comparable<K>, V> {

    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int n;

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    private int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.n;
        }
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            return get(root.left, key);
        } else if (cmp > 0) {
            return get(root.right, key);
        } else {
            return root.value;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node root, K key, V value) {
        if (root == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        root.n = size(root.left) + size(root.right) + 1;
        return root;
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node root) {
        if (root.right == null) {
            return root;
        }
        return max(root.right);
    }

    public K floor(K key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp == 0) {
            return root;
        }
        if (cmp < 0) {
            return floor(root.left, key);
        }
        Node t = floor(root.left, key);
        if (t != null) {
            return t;
        } else {
            return root;
        }
    }
}
