package com.tss.filehandling;

import com.tss.exception.CapacityFullException;

import java.io.IOException;
import java.util.Scanner;

public class MovieApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MovieController mc = new MovieController(); //Throw exceptoin

        if(mc.manager.getSize() >= 5)
            throw new CapacityFullException("Capacity full");

        Movie movie = new Movie();
        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        System.out.println("Enter Movie Name: ");
        String name = sc.nextLine();

        sc.nextLine();
        System.out.println("Enter genre: ");
        String genre = sc.nextLine();

        System.out.println("Enter year: ");
        int year = sc.nextInt();

        movie.setId();
        movie.setName(name);
        movie.setYear(year);
        movie.setGenre(genre);
    }
}
