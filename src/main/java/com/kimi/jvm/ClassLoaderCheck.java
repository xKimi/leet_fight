package com.kimi.jvm;

import com.kimi.Test;
import sun.misc.Launcher;

import java.net.URL;

/**
 * Created on 2021/4/11.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class ClassLoaderCheck {

    public static void main(String[] args) {
        try {
            URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
            for (URL url : urLs) {
                System.out.println(url.toExternalForm());
            }

            System.out.println(String.class.getClassLoader());

            System.out.println(Test.class.getClassLoader().getParent());

            System.out.println(String.class.getClassLoader().getParent());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
