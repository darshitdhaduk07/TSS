package com.tss.oop;

public class Truck implements Vehicle {
    private boolean isHorn = false;
    private boolean isPlayMusic = false;
    private int id;
    private boolean isStarted = false;

    public Truck(int id,boolean isHorn,boolean isPlayMusic)
    {
        this.id = id;
        this.isHorn = isHorn;
        this.isPlayMusic = isPlayMusic;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId(){return id;}

    public void setIsHorn(boolean isHorn)
    {
        this.isHorn = isHorn;
    }

    public void setIsPlayMusic(boolean isPlayMusic)
    {
        this.isPlayMusic = isPlayMusic;
    }

    @Override
    public void start() {
        if(isStarted)
            System.out.println("\nTruck already Started\n");
        else
        {
            isStarted = true;
            System.out.println("\nTruck Started\n");
        }
    }

    @Override
    public void stop() {
        if(isStarted)
        {
            isStarted = false;
            System.out.println("\nTruck Stopped\n");
        }
        else
            System.out.println("\nTruck already Stopped\n");
    }

    @Override
    public void horn()
    {
        if(isHorn)
            System.out.println("\nHonk Honk...\n");
        else
            Vehicle.super.horn();

    }

    @Override
    public void playMusic()
    {
        if(isPlayMusic)
            System.out.println("\nMusic Played\n");
        else
            Vehicle.super.playMusic();
    }
    public void inspection(){
        System.out.println("\nTruck inspection done\n");
    }

}
