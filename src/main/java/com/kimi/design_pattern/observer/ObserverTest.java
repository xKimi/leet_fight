package com.kimi.design_pattern.observer;

/**
 * Description:
 * Copyright @2021 xKimi.inc
 *
 * @author Kimi
 * @date 2021/7/14
 */
public class ObserverTest {

    public static void main(String[] args) {
        Publisher p = new PublisherImpl("test", 10);
        Observer o = new ObserverImpl();
        p.addObserver(o);
        p.notify(12);
    }
}
