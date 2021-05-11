package com.kimi.others.linkedlist;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/5/11 10:35
 */
public class CustomLinkedList {

    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {

        private Node first;
        private Node last;
        private int size;

        private DoubleList() {
            this.first = null;
            this.last = null;
            this.size = 0;
        }

        public void addFirst(Node x) {
            if (first == null) {
                last = x;
            } else {
                first.prev = x;
                x.next = first;
            }
            first = x;
            size++;
        }

        public void remove(Node x) {
            Node current = first;
            while (current.key != x.key) {
                if (current.next == null) {
                    size--;
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
            Node tmp = last;
            if (first == null) {
                size--;
                return null;
            }
            if (first.next == null) {
                first = null;
                last = null;
            } else {
                last.prev.next = null;
                last = tmp.prev;
            }
            size--;
            return tmp;
        }

        public int size() {
            return size;
        }
    }
}
