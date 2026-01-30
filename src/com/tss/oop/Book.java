package com.tss.oop;

import java.util.Objects;

public class Book{
    private int bookId;
    private String title;
    private boolean isIssued;
    private Member issuedTo = null;

    public Book()
    {

    }
    public Book(int bookId,String title)
    {
        this.bookId = bookId;
        this.title = title;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public void setIssuedTo(Member m)
    {
        this.issuedTo = m;
        setIssued(true);
    }
    public void returnBook()
    {
        issuedTo = null;
        isIssued = false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }
}
