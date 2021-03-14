package com.kimi.design_pattern.adapter.template_method;

/**
 * Created on 2021/3/14.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public abstract class AbstractDisplay {

    public abstract void open();

    public abstract void print();

    public abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
