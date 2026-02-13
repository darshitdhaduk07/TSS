package com.tss.designpattern.creationaldesignpattern.singleton;

public class Singleton {


    private Singleton() {
        System.out.println("Singleton Instance Created");
    }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }


    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
