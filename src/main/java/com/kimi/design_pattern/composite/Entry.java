package com.kimi.design_pattern.composite;

/**
 * Created on 2021/6/1.
 * Copyright xKimi.inc
 *
 * @author Kimi
 * @date 2021/6/1
 */
public abstract class Entry {
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
