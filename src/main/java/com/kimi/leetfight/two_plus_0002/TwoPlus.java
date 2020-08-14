package com.kimi.leetfight.two_plus_0002;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/8/14 18:27
 * @Author Feng Yalong
 */
public class TwoPlus {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode current = pre;
        int carryBit = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carryBit;

            carryBit = sum / 10;
            sum = sum % 10;
            current.next = new ListNode(sum);

            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carryBit == 1) {
            current.next = new ListNode(carryBit);
        }
        return pre.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
