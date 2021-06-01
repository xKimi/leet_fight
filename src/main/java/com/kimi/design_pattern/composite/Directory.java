package com.kimi.design_pattern.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created on 2021/6/1.
 * Copyright xKimi.inc
 *
 * @author Kimi
 * @date 2021/6/1
 */
@SuppressWarnings(value = "unchecked")
public class Directory extends Entry {

    private String name;

    private ArrayList directory = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Object o : directory) {
            Entry entry = (Entry) o;
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.printList(prefix + "/" + name);
        }
    }
}
