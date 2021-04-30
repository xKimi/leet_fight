package com.kimi.spi;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/4/29 16:15
 */
public class Dog implements IAnimal {
    @Override
    public void shout() {
        System.out.println("wang");
    }
}
