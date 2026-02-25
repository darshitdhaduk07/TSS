package com.tss.designpattern.structural.hotelservice.model;

public class Reception {
    LuggageSurvice luggageSurvice;
    RestorantService restorantService;
    RoomService roomService;

    public Reception()
    {
        luggageSurvice = new LuggageSurvice();
        restorantService = new RestorantService();
        roomService = new RoomService();
    }

    public void checkIn()
    {
        luggageSurvice.pickLuggage();
        roomService.cleanRoom();
        restorantService.serveFood();
    }

    public void checkOut()
    {
        luggageSurvice.pickLuggage();
        roomService.closeRoom();
    }
}
