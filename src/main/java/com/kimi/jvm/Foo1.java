package com.kimi.jvm;

/**
 * @author Kimi
 * @date 2021/5/19 17:51
 */
public class Foo1 {

    int a = 0;

    static int bar(int x) {
        Foo1 foo1 = new Foo1();
        foo1.a = x;
        return foo1.a;
    }
}
