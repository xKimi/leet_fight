package com.kimi.design_pattern.observer;

/**
 * Description:
 * Copyright @2021 xKimi.inc
 *
 * @author Kimi
 * @date 2021/7/14
 */
public interface Observer {

    void notify(String account, double amount);
}
