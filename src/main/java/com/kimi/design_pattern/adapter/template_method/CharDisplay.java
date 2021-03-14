package com.kimi.design_pattern.adapter.template_method;

/**
 * Created on 2021/3/14.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class CharDisplay extends AbstractDisplay {

    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.print(">>");
    }
}
