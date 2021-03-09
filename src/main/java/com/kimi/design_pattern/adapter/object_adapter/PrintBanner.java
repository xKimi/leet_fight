package com.kimi.design_pattern.adapter.object_adapter;

import com.kimi.design_pattern.adapter.class_adapter.Banner;

/**
 * Created on 2021/3/10.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class PrintBanner extends Print {

    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
