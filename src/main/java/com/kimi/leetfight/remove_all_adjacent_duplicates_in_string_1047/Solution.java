package com.kimi.leetfight.remove_all_adjacent_duplicates_in_string_1047;

import java.util.Stack;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/3/9 15:30
 */
public class Solution {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = S.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (stack.empty()) {
                stack.push(charArray[i]);
                continue;
            }
            if (stack.peek() == charArray[i]) {
                stack.pop();
            } else {
                stack.push(charArray[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        int length = stack.size();
        for (int i = 0; i < length; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }
}
