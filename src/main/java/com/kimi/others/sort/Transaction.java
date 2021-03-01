package com.kimi.others.sort;

import java.util.Comparator;
import java.util.Date;

/**
 * Copyright (c) 2021 Kimi. All Rights Reserved
 *
 * @Date 2021/3/1 18:21
 * @Author Feng Yalong
 */
public class Transaction {

    private String who;

    private Date when;

    private Double amount;

    public static class WhoOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.who.compareTo(o2.who);
        }
    }

    public static class WhenOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.when.compareTo(o2.when);
        }
    }

    public static class HowMuchOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.amount.compareTo(o2.amount);
        }
    }
}
