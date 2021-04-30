package com.kimi.spi;

import java.util.ServiceLoader;

/**
 * Copyright (c) 2021. All Rights Reserved
 *
 * @author Feng Yalong
 * @date 2021/4/29 16:17
 */
public class SPITest {

    public static void main(String[] args) {
        ServiceLoader<IAnimal> shouts = ServiceLoader.load(IAnimal.class);
        for (IAnimal s : shouts) {
            s.shout();
        }
    }
}
