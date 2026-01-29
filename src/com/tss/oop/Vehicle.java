package com.tss.oop;

public interface Vehicle {

    public void start();
    public void stop();

    public int getId();
    default void horn(){
        System.out.println("This feature is not supported");
    }

    default void playMusic()
    {
        System.out.println("This feature is not supported");
    }

    public static void inspection(Vehicle v)
    {
        System.out.println("Inspection done of "+v.getClass().getSimpleName());
    }

    default void chargeBattery()
    {
        System.out.println("This feature is not supported");
    }

}
