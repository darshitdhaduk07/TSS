package com.tss.filehandling;

public class Movie {

    private static int counter = 0;
    private int id;
    private String name;
    private int year;
    private String genre;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public void setId() {
        this.id = ++counter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
