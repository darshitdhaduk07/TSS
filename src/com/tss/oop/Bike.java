package com.tss.oop;

public class Bike implements Vehicle {
    private boolean isHorn = false;
    private boolean isPlayMusic = false;
    private int id;
    private boolean isStarted = false;

    public Bike(int id,boolean isHorn,boolean isPlayMusic)
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
            System.out.println("\nBike already Started\n");
        else
        {
            isStarted = true;
            System.out.println("\nBike Started\n");
        }
    }

    @Override
    public void stop() {
        if(isStarted)
        {
            isStarted = false;
            System.out.println("\nBike Stop\n");
        }
        else
            System.out.println("\nBike already Stopped\n");
    }

    @Override
    public void horn()
    {
        if(isHorn)
            System.out.println("\nPip Pip....\n");
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
        System.out.println("\nBike inspection done\n");
    }
}
