package com.tss.filehandling;

import com.tss.exception.CapacityFullException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MovieApp {
    public static Scanner sc  = new Scanner(System.in);
    public static MovieController mc; //Throw exceptoin

    static {
            mc = new MovieController();
    }
    public static void displayMovies(){
        mc.manager.loadMovies();
        List<Movie>movies = mc.manager.getMovies();

        int i = 1;
        for(Movie m : movies)
        {
            if (m == null)
            {
                continue;
            }
            else{
                System.out.println("----- Movie "+i+" -----");
                System.out.println("\nMovie Id: "+m.getId());
                System.out.println("Movie Name: "+m.getName());
                System.out.println("Movie Year: "+m.getYear());
                System.out.println("Movie genre: "+m.getGenre()+"\n");
                i++;
            }
        }
    }

    public static void addMovies()
    {
        if(mc.manager.getSize() >= 5)
            throw new CapacityFullException("Capacity full");

        int id = mc.manager.getMovies().size()+1;

        Movie movie = new Movie();
        sc.nextLine();
        System.out.println("Enter Movie Name: ");
        String name = sc.nextLine();

        System.out.println("Enter genre: ");
        String genre = sc.nextLine();

        System.out.println("Enter year: ");
        int year = sc.nextInt();

        movie.setId(id);
        movie.setName(name);
        movie.setYear(year);
        movie.setGenre(genre);

        mc.manager.addMovie(movie);
    }
    public static void main(String[] args){

        while(true){
            mc.start();

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    displayMovies();
                    break;
                case 2:
                    addMovies();
                    break;
                case 3:
                    mc.manager.clearMovies();
                    break;
                case 4:
                    mc.manager.deleteAllMovies();
                    break;
                case 5:
                    mc.manager.saveMovies();
                    break;
                case 6:
                    return;
            }
        }
    }
}
