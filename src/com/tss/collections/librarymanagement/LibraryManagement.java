package com.tss.collections.librarymanagement;

import com.tss.validate.InputValidator;

import java.util.*;

public class LibraryManagement {
    private ArrayList<Member> members;
    private ArrayList<Book> books;
    private ArrayList<BookCopy> libraryBooks;
    private Set<String> emails;
    static Map<Member, ArrayList<BookCopy>> memberHasBooks;

    public  LibraryManagement() {
        members = new ArrayList<>();
        books = new ArrayList<>();
        libraryBooks = new ArrayList<>();
        emails = new HashSet<>();
        memberHasBooks = new HashMap<>();
    }
    public static ArrayList<BookCopy>getMemberBookList(Member m)
    {
        for (Map.Entry<Member, ArrayList<BookCopy>> entry : memberHasBooks.entrySet()) {

            Member member = entry.getKey();
            if(member == m)
            {
                return entry.getValue();
            }

        }
        return null;
    }
    public Member getMemberById() {
        if(members.isEmpty())
        {
            System.out.println("\nPlease Enter Member First");
            return null;
        }

        int id = InputValidator.readInt("Enter Member id: ");


        while (true)
        {
            for(Member member : members) {
                if(member == null)
                {
                    continue;
                }
                else if(member.getId() == id)
                {
                    return member;
                }
            }
            id = InputValidator.readInt("Enter Correct Member id: ");
        }
    }
    public BookCopy getBookById() {
        int id = InputValidator.readInt("Enter Book Id: ");

        while (true)
        {
            for(BookCopy book : libraryBooks) {
                if(book == null)
                    continue;
                else if(book.getId() == id)
                    return book;
            }
            id = InputValidator.readInt("Enter Correct Book Id: ");
        }
    }
    public void addBook() {
        if(books.isEmpty())
        {
            System.out.println("\nPlease add a book in Template\n");
            return;
        }

        int isbn = InputValidator.readInt("Enter ISBN Number: ");

        BookCopy bookCopy;

        while (true){
            for(Book book:books){
                if(book == null)
                    continue;
                else if(book.getIsbn() == isbn){
                    bookCopy = new BookCopy(book);
                    libraryBooks.add(bookCopy);
                    System.out.println("\nBook Added Successfully\n");
                    return;
                }
            }
            System.out.println("Book is not present with ISBN number " + isbn);
            isbn = InputValidator.readInt("Enter ISBN Number: ");
        }

    }

    public void addMember() {
        String name = InputValidator.readString("Enter your Name: ");
        String email = InputValidator.readEmail("Enter your Email: ");

        while (true)
        {
            int flag = 0;
            for(String e : emails)
            {
                if(e.equals(email))
                {
                    flag = 1;
                    email = InputValidator.readEmail("This Email already exists! Enter new one: ");
                    break;
                }
            }
            if(flag == 0)
                break;
        }
        emails.add(email);
        Member member = new Member(name,email);
        members.add(member);
        System.out.println("\nMember Added Successfully with id: "+member.getId());
    }

    public void borrowBook() {
        if(libraryBooks.isEmpty())
        {
            System.out.println("\nPlease add a book in Library\n");
            return;
        }

        if(members.isEmpty())
        {
            System.out.println("\nPlease add a member First\n");
            return;
        }

        BookCopy b = getBookById();

        if(b.isBorrowed())
        {
            System.out.println("\nBook Already Borrowed\n");
            return;
        }

        Member member = getMemberById();
        b.setBorrower(member);
        ArrayList<BookCopy> m = getMemberBookList(member);
        if(m == null)
        {
            m = new ArrayList<>();
        }
        m.add(b);
        memberHasBooks.put(member,m);
        System.out.println("\nBook Borrowed Successfully\n");
    }

    public void returnBook() {

        if(libraryBooks.isEmpty())
        {
            System.out.println("\nPlease add a book in Library\n");
            return;
        }

        BookCopy bookCopy = getBookById();

        if(!bookCopy.isBorrowed())
        {
            System.out.println("\nBorrow Book First Borrowed\n");
            return;
        }

        Member member = bookCopy.getBorrower();
        memberHasBooks.get(member).remove(bookCopy);
        bookCopy.returnBook();
        System.out.println("\nBook Returned Successfully\n");
    }

    public void viewAllBooks() {
        if(libraryBooks.isEmpty())
        {
            System.out.println("\nPlease add a book in Library\n");
            return;
        }

        System.out.printf(
                "%-5s %-10s %-20s %-25s%n",
                "ID", "Borrowed", "Borrower", "Book"
        );

        System.out.println("---------------------------------------------------------------");

        for (BookCopy bookCopy : libraryBooks) {
            System.out.println(bookCopy.toTableRow());
        }
    }

    public void viewAllMembersInLibrary() {
        if(members.isEmpty())
        {
            System.out.println("\nPlease add a member First\n");
            return;
        }
        System.out.printf(
                "%-5s %-20s %-30s%n",
                "ID", "Name", "Email"
        );
        System.out.println("------------------------------------------------------------");

        for (Member member : members) {
            System.out.println(member);
        }


    }

    public void viewBooksBorrowedByMember(){
        if(memberHasBooks.isEmpty())
        {
            System.out.println("\nNot single Book borrowed by any member\n");
            return;
        }


        System.out.printf(
                "%-5s %-20s %-30s %-40s%n",
                "ID", "Member Name", "Email", "Borrowed Books"
        );

        System.out.println("--------------------------------------------------------------------------------------------");

        for (Map.Entry<Member, ArrayList<BookCopy>> entry : memberHasBooks.entrySet()) {

            Member member = entry.getKey();
            ArrayList<BookCopy> books = entry.getValue();

            String borrowedBooks;

            if (books == null || books.isEmpty()) {
                borrowedBooks = "None";
            } else {
                borrowedBooks = books.stream()
                        .map(bc -> bc.getBook().getTitle())
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("None");
            }

            System.out.printf(
                    "%-5d %-20s %-30s %-40s%n",
                    member.getId(),
                    member.getName(),
                    member.getEmail(),
                    borrowedBooks
            );
        }



    }

    public void bookBorrowedBy()
    {
        if(libraryBooks.isEmpty())
        {
            System.out.println("\nPlease add a book in Library\n");
            return;
        }

        BookCopy bookCopy = getBookById();
        System.out.println("\n---- Book Borrowed by ----");
        if(bookCopy.getBorrower() == null)
        {
            System.out.println("None");
            return;
        }
        System.out.println("Member name: "+bookCopy.getBorrower().getName());
        System.out.println("Member email: "+bookCopy.getBorrower().getEmail()+"\n");

    }
    public void viewAllBooksBorrowedByMember()
    {
        if(memberHasBooks.isEmpty())
        {
            System.out.println("\nNot single Book borrowed by any member\n");
            return;
        }
        Member m = getMemberById();

        System.out.printf(
                "%-5s %-20s %-30s %-40s%n",
                "ID", "Member Name", "Email", "Borrowed Books"
        );

        System.out.println("--------------------------------------------------------------------------------------------");


        for (Map.Entry<Member, ArrayList<BookCopy>> entry : memberHasBooks.entrySet()) {
            Member member = entry.getKey();

            if(member == m)
            {
                ArrayList<BookCopy> books = entry.getValue();

                String borrowedBooks;

                if (books == null || books.isEmpty()) {
                    borrowedBooks = "None";
                } else {
                    borrowedBooks = books.stream()
                            .map(bc -> bc.getBook().getTitle())
                            .reduce((a, b) -> a + ", " + b)
                            .orElse("None");
                }

                System.out.printf(
                        "%-5d %-20s %-30s %-40s%n",
                        member.getId(),
                        member.getName(),
                        member.getEmail(),
                        borrowedBooks
                );
                return;
            }

        }
        System.out.println("\nThis member not Borrowed any book\n");


    }
    public void addBookToBookTemplate()
    {
        String bookTitle = InputValidator.readString("Enter Book Title: ");
        String bookAuthor = InputValidator.readString("Enter Book Author: ");
        String bookCategory = InputValidator.readString("Enter Book Category: ");

        Book book = new Book(bookTitle, bookAuthor, bookCategory);
        books.add(book);
        System.out.println("\nBook Added Successfully with ISBN: "+book.getIsbn()+"\n");
    }

}
