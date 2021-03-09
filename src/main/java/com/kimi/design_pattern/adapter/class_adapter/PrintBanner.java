package com.kimi.design_pattern.adapter.class_adapter;

/**
 * Created on 2021/3/10.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
