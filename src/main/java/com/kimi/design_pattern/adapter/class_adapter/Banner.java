package com.kimi.design_pattern.adapter.class_adapter;

/**
 * Created on 2021/3/10.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class Banner {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
