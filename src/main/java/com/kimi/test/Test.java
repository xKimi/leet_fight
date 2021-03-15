package com.kimi.test;

import java.util.stream.Stream;

/**
 * Created on 2021/3/12.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class Test {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6)
                .parallel()
                .reduce((a, b) -> {
                    System.out.println(Thread.currentThread().getName() + " a + b = " + (a + b));
                    return a + b;
                }).ifPresent(System.out::println);
    }
}
