package com.tss.collections.librarymanagement.app;

import com.tss.collections.librarymanagement.service.LibraryManagement;
import com.tss.validate.InputValidator;

public class LibraryApp {
    public static void main(String[] args) {

        LibraryManagement libraryManagement = new LibraryManagement();


        while (true){
            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Book to Library");
            System.out.println("2. Register New Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View All Members");
            System.out.println("7. View All Borrowed Books");
            System.out.println("8. View Borrower of a Book");
            System.out.println("9. View All Borrowed Books By Member");
            System.out.println("10. Add Book to Book Template");
            System.out.println("0. Exit");
            System.out.println("==============================================");


            int choice = InputValidator.readInt("--> Enter your Choice: ");
            switch (choice)
            {
                case 1:
                    libraryManagement.addBook();
                    break;
                case 2:
                    libraryManagement.addMember();
                    break;
                case 3:
                    libraryManagement.borrowBook();
                    break;
                case 4:
                    libraryManagement.returnBook();
                    break;
                case 5:
                    libraryManagement.viewAllBooks();
                    break;
                case 6:
                    libraryManagement.viewAllMembersInLibrary();
                    break;
                case 7:
                    libraryManagement.viewBooksBorrowedByMember();
                    break;
                case 8:
                    libraryManagement.bookBorrowedBy();
                    break;
                case 9:
                    libraryManagement.viewAllBooksBorrowedByMember();
                    break;
                case 10:
                    libraryManagement.addBookToBookTemplate();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
