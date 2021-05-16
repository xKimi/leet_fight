package com.kimi.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/5/14 11:31
 */
public class TestBoolean {

    static boolean booleanValue;

    private static boolean getValue() {
        return booleanValue;
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        booleanValue = true;
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        Field field = TestBoolean.class.getDeclaredField("booleanValue");
        field.setAccessible(true);
        unsafe.putByte(booleanValue, unsafe.staticFieldOffset(field), (byte) 2);

        System.out.println("booleanValue = " + booleanValue);
        System.out.println("getValue = " + getValue());
    }
}
