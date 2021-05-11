package com.kimi.others.linkedlist;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/5/8 17:10
 */
public class MyLinkedList {

    private ListNode dummy;

    private ListNode tail;

    private int length;

    class ListNode {
        public int val = 0;

        public ListNode next = null;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        dummy = new ListNode();
        tail = dummy;
        length = 0;
    }

    public void addAtTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
        length++;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummy.next;
        dummy.next = newNode;
        if (tail == dummy) {
            tail = newNode;
        }
        length++;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        return getPrevNode(index).next.val;
    }

    private ListNode getPrevNode(int index) {
        ListNode front = dummy.next;
        ListNode back = dummy;
        for (int i = 0; i < index && front != null; i++) {
            back = front;
            front = front.next;
        }
        return back;
    }

    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        } else if (index == length) {
            addAtTail(val);
        } else if (index <= 0) {
            addAtHead(val);
        } else {
            ListNode pre = getPrevNode(index);
            ListNode p = new ListNode(val);
            p.next = pre.next;
            pre.next = p;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        ListNode pre = getPrevNode(index);
        if (tail == pre.next) {
            tail = pre;
        }
        pre.next = pre.next.next;
        length--;
    }

    public ListNode reserveList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }

        return dummy.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head != null) {
            ListNode back = head.next;
            if (head.val != val) {
                tail.next = head;
                tail = head;
            }
            head = back;
        }
        tail.next = null;
        return dummy.next;
    }
}
