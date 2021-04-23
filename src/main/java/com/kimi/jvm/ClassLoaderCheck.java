package com.kimi.jvm;

import com.kimi.Test;

/**
 * Created on 2021/4/11.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class ClassLoaderCheck {

    public static void main(String[] args) {
        try {
            System.out.println(String.class.getClassLoader());

            System.out.println(Test.class.getClassLoader().getParent());

            System.out.println(String.class.getClassLoader().getParent());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
