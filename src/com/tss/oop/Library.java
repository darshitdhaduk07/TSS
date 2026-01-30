package com.tss.oop;

public class Library {
    public static Book books[];
    private static int capacity = 0;
    public static int coutNumberOfBooks = 0;

    public Library(int c)
    {
        capacity = c;
        books = new Book[c];
    }

    public void addBook(Book b)
    {
        if(books.length > capacity)
        {
            System.out.println("you cant add book");
        }
        else {
            books[coutNumberOfBooks++] = b;
        }
    }

    public void issueTo(int bookId, Member m)
    {
        for(Book b : books)
        {
            if(b == null)
            {
                continue;
            }
            else if(b.getBookId() == bookId && !b.isIssued())
            {
                b.setIssued(true);
                b.setIssuedTo(m);
                System.out.println("book issued");
                return;
            }
            else if(b.getBookId() == bookId)
            {
                System.out.println("Book is already issued");
                return;
            }
        }
        System.out.println("invalid book id");
    }

    public void returnBook(int bookId)
    {
        for(Book b : books)
        {
            if(b == null)
            {
                continue;
            }
            else if(b.getBookId() == bookId && !b.isIssued())
            {
                System.out.println("This book is not issued");
                return;
            }
            else if(b.getBookId() == bookId && b.isIssued())
            {
                b.returnBook();
                b.setIssuedTo(null);
                System.out.println("returned");
                return;
            }

        }
        System.out.println("invalid bookId");
    }

    public void showBooks()
    {
        for(Book b:books)
        {
            if(b == null)
                continue;
            System.out.println("Book id: "+b.getBookId());
            System.out.println("Book name: "+b.getTitle());
        }
    }
    public Book findBook(int bookId)
    {
        for(Book b : books)
        {
            if(b == null)
                continue;
            else if(b.getBookId() == bookId)
                return  b;

        }
        System.out.println("Invalid book id");
        return null;
    }


}
