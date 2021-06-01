package com.kimi.design_pattern.composite;

/**
 * Created on 2021/6/1.
 * Copyright xKimi.inc
 *
 * @author Kimi
 * @date 2021/6/1
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Making entries ...");
            Directory rootDir = new Directory("root");
            Directory binDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");
            rootDir.add(binDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);
            binDir.add(new File("vi", 10000));
            binDir.add(new File("latex", 20000));
            rootDir.printList();

            System.out.println("");
            System.out.println("making user entries");
            Directory usr1 = new Directory("usr1");
            Directory usr2 = new Directory("usr2");
            Directory usr3 = new Directory("usr3");
            usrDir.add(usr1);
            usrDir.add(usr2);
            usrDir.add(usr3);
            usr1.add(new File("a.txt", 100));
            usr1.add(new File("composite.java", 200));
            usr2.add(new File("hello.txt", 300));
            usr3.add(new File("usr4.txt", 400));
            usr3.add(new File("usr5.txt", 500));
            rootDir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
