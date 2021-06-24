package com.kimi.others.stack;

import java.util.Arrays;

/**
 * Description:
 * Copyright @2021 xKimi.inc
 *
 * @author Kimi
 * @date 2021/6/24
 */
public class CustomStack {

    private int cap;

    private int[] elements;

    private int count;

    private static final int GROW_FACTOR = 2;

    public CustomStack() {
        this.cap = 8;
        this.count = 0;
        this.elements = new int[8];
    }

    public CustomStack(int cap) throws IllegalAccessException {
        if (cap < 1) {
            throw new IllegalAccessException("cap is too small");
        }
        this.cap = cap;
        this.count = 0;
        this.elements = new int[cap];
    }

    public void push(int val) {
        if (count == cap) {
            ensureCapacity();
        }
        elements[count++] = val;
    }

    private void ensureCapacity() {
        int newCap = cap * GROW_FACTOR;
        elements = Arrays.copyOf(elements, newCap);
        cap = newCap;
    }

    public int pop() throws IllegalAccessException {
        checkIfStackEmpty();
        return elements[--count];
    }

    public int peek() throws IllegalAccessException {
        checkIfStackEmpty();
        return elements[count - 1];
    }

    private void checkIfStackEmpty() throws IllegalAccessException {
        if (count == 0) {
            throw new IllegalAccessException("stack is empty");
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }
}
