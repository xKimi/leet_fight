package com.kimi.jvm;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/5/14 14:23
 */
public class TestClassLoader {

    // final修饰，且为静态类型或字符串，初始化阶段被标记为ConstantValue
    private static final int INT_A = 1;
    // 初始化阶段被置于<clinit>中
    private static final int INT_B;

    // 初始化阶段被置于<clinit>中
    static {
        INT_B = 2;
    }

    public static void main(String[] args) {

    }
}
