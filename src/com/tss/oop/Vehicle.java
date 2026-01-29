package com.tss.oop;

public interface Vehicle {

    public void start();
    public void stop();

    public int getId();
    default void horn(){
        System.out.println("\nThis feature is not supported\n");
    }

    default void playMusic()
    {
        System.out.println("\nThis feature is not supported\n");
    }

    public void inspection();

    default void chargeBattery()
    {
        System.out.println("\nThis feature is not supported\n");
    }

}
