package com.kimi.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Copyright @2021 xKimi.inc
 *
 * @author Kimi
 * @date 2021/7/14
 */
public class PublisherImpl implements Publisher {

    private String account;

    private double balance;

    private List<Observer> observers;

    public PublisherImpl(String account, double balance) {
        this.account = account;
        this.balance = balance;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notify(double amount) {
        balance -= amount;
        if (balance < 0) {
            for (Observer o : observers) {
                o.notify(account, balance);
            }
        }
    }
}
