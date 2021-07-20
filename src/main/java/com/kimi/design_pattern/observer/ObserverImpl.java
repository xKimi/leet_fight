package com.kimi.design_pattern.observer;

/**
 * Description:
 * Copyright @2021 xKimi.inc
 *
 * @author Kimi
 * @date 2021/7/14
 */
public class ObserverImpl implements Observer {
    @Override
    public void notify(String account, double amount) {
        System.out.println("账号：" + account + "， 余额：" + amount);
    }
}
