package com.kimi.others.stack.monotonous;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/3/21 18:01
 */
public class NextGreaterElement {

    public static List<Integer> nextGreaterElement(List<Integer> nums) {
        Stack<Integer> s = new Stack<>();
        List<Integer> result = new ArrayList<>(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            result.add(-1);
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums.get(i)) {
                s.pop();
            }
            result.set(i, s.empty() ? -1 : s.peek());
            s.push(nums.get(i));
        }
        return result;
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            result[i] = s.empty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Stream.of(2, 1, 2, 4, 3).collect(Collectors.toList());
        System.out.println(nextGreaterElement(list));
    }
}
