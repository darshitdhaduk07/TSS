package com.tss.collections.librarymanagement.module;

public class BookCopy {
    private int id;
    public static int counter = 0;
    private boolean isBorrowed = false;
    private Member borrower = null;
    Book book = null;

    public BookCopy() {}
    public BookCopy(Book book) {
        this.id =  ++counter;
        this.book = book;

    }
    public int getId() {
        return id;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public Book getBook() {
        return book;
    }

    public Member getBorrower() {
        return borrower;
    }
    public void setBorrower(Member borrower) {
        this.borrower = borrower;
        this.isBorrowed = true;
    }

    public void returnBook(){
        this.isBorrowed = false;
        this.borrower = null;
    }

    public String toTableRow() {
        return String.format(
                "%-5d %-10s %-20s %-25s",
                id,
                isBorrowed ? "Yes" : "No",
                borrower != null ? borrower.getName() : "None",
                book != null ? book.getTitle() : "None"
        );
    }





}
