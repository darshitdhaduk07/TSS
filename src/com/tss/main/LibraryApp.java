package com.tss.main;

import com.tss.oop.Book;
import com.tss.oop.Library;
import com.tss.oop.Member;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library(10);

        Book onebook = new Book(1,"rich dad poor dad");
        Book secondbook = new Book(1,"rich dad poor dad");

        library.addBook(onebook);
        Member one = new Member(1,"Darshit");

        library.issueTo(1,one);


        library.issueTo(1,one);

        library.returnBook(1);

        String str = "darshit";

        String str1 = new String("darshit").intern();

        System.out.println(str == str1); //false
        System.out.println(str.equals(str1)); //true

        System.out.println(onebook == secondbook);
        System.out.println(onebook.equals(secondbook));


        System.out.println(Library.class.getConstructors());
    }
}
