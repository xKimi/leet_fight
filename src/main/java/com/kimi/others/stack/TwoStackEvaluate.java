package com.kimi.others.stack;

import java.util.Stack;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/2/23 17:21
 * @Author Feng Yalong
 */
public class TwoStackEvaluate {

    public static void main(String[] args) throws Exception {
        Stack<Double> values = new Stack<>();
        Stack<String> operates = new Stack<>();
        for (String cur : args) {
            if ("(".equals(cur)) {
            } else if ("+".equals(cur)) {
                operates.push(cur);
            } else if ("-".equals(cur)) {
                operates.push(cur);
            } else if ("*".equals(cur)) {
                operates.push(cur);
            } else if ("/".equals(cur)) {
                operates.push(cur);
            } else if (")".equals(cur)) {
                // 遇到右括号进行运算
                Double v1 = values.pop();
                Double v2 = values.pop();
                String op = operates.pop();
                if ("+".equals(op)) {
                    values.push(v1 + v2);
                } else if ("-".equals(op)) {
                    values.push(v2 - v1);
                } else if ("*".equals(op)) {
                    values.push(v1 * v2);
                } else if ("/".equals(op)) {
                    values.push(v2 / v1);
                } else {
                    throw new Exception("unknow operator");
                }
            } else {
                values.push(Double.parseDouble(cur));
            }
        }
    }
}
