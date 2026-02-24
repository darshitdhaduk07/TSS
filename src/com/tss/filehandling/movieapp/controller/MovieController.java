package com.tss.filehandling.movieapp.controller;

public class MovieController {
    public MovieManager manager;

    public MovieController(){
        manager = new MovieManager();
    }

    public void start()
    {
        displayMenu();
    }

    private void displayMenu()
    {
        System.out.println("1. Display Movies");
        System.out.println("2. Add Movies");
        System.out.println("3. Clear All Movies");
        System.out.println("4. Delete all moves");
        System.out.println("5. Save All Movies");
        System.out.println("6. Exit");

    }


}
