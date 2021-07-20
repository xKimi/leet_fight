package com.kimi.design_pattern.observer;

/**
 * Description:
 * Copyright @2021 xKimi.inc
 *
 * @author Kimi
 * @date 2021/7/14
 */
public interface Publisher {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notify(double amount);
}
