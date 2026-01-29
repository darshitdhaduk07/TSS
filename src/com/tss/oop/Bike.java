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
            System.out.println("Bike already Started");
        else
        {
            isStarted = true;
            System.out.println("Bike Started");
        }
    }

    @Override
    public void stop() {
        if(isStarted)
        {
            isStarted = false;
            System.out.println("Bike Stop");
        }
        else
            System.out.println("Bike already Stopped");
    }

    @Override
    public void horn()
    {
        if(isHorn)
            System.out.println("Pip Pip....");
        else
            Vehicle.super.horn();

    }

    @Override
    public void playMusic()
    {
        if(isPlayMusic)
            System.out.println("Music Played");
        else
            Vehicle.super.playMusic();
    }
}
