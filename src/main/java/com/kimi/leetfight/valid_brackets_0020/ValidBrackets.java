package com.kimi.leetfight.valid_brackets_0020;

import java.util.Stack;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/10/13 15:36
 * @Author Feng Yalong
 */
public class ValidBrackets {

    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
