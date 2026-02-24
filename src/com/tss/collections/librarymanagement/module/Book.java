package com.tss.collections.librarymanagement.module;


public class Book{
    private long isbn;
    private static long counter = 1000000000;
    private String title;
    private String author;
    private String category;

    public Book(String title, String author, String category){
        this.isbn = ++counter;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        Book.counter = counter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getIsbn() {
        return isbn;
    }

}
