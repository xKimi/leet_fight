package com.kimi.stream.predicate;

/**
 * Created on 2021/3/21.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class ColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("red");
    }
}
