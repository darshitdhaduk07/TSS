package com.tss.oop;

public class EVBike implements ElectricVehicle {
    private boolean isHorn = false;
    private boolean isPlayMusic = false;
    private int id;
    private boolean isStarted = false;

    public EVBike(int id, boolean isHorn, boolean isPlayMusic)
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
            System.out.println("\nEv-Car already Started\n");
        else
        {
            isStarted = true;
            System.out.println("\nEv-Car Started\n");
        }
    }

    @Override
    public void stop() {
        if(isStarted)
        {
            isStarted = false;
            System.out.println("\nEv-Bike Stopped\n");
        }
        else
            System.out.println("\nEv-Car already Stopped\n");
    }

    @Override
    public void horn()
    {
        if(isHorn)
            System.out.println("\nPip Pip....\n");
        else
            ElectricVehicle.super.horn();

    }

    @Override
    public void playMusic()
    {
        if(isPlayMusic)
            System.out.println("\nMusic Played\n");
        else
            ElectricVehicle.super.playMusic();
    }
    public void inspection(){
        System.out.println("\nEv bike inspection done\n");
    }
    public void chargeBattery(){
        System.out.println("\nEv-Car charged\n");
    }
}
