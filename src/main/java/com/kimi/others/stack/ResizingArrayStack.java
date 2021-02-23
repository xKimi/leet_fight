package com.kimi.others.stack;

import java.util.Iterator;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/2/23 18:02
 * @Author Feng Yalong
 */
public class ResizingArrayStack<Item> implements Iterator<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        if (n >= 0) {
            System.arraycopy(a, 0, temp, 0, n);
        }
        a = temp;
    }

    public void push(Item item) {
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = item;
    }

    public Item pop() {
        Item item = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length >>> 2) {
            resize(a.length >>> 1);
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }


}
