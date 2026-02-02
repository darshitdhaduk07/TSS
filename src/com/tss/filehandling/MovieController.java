package com.tss.filehandling;

import com.tss.exception.CapacityFullException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MovieController {
    public MovieManager manager;

    public MovieController() throws IOException, ClassNotFoundException {
        manager = new MovieManager();
    }

    public void start()
    {
        displayMenu();
    }

    private void displayMenu()
    {
//        List<Movie> movieList = manager.getMovies();
//        int i = 1;
//        for(Movie m : movieList)
//        {
//            if (m == null)
//            {
//                continue;
//            }
//            else{
//                System.out.println("----- Movie "+i+" -----");
//                System.out.println("Movie Id: "+m.getId());
//                System.out.println("Movie Name: "+m.getName());
//                System.out.println("Movie Year: "+m.getYear());
//                System.out.println("Movie genre: "+m.getGenre());
//                i++;
//            }
//        }
        System.out.println("1. Display Movies");
        System.out.println("2. Add Movies");
        System.out.println("3. Clear All Movies");
        System.out.println("4. Exit");

    }

    public void setMovieDetails()
    {


    }
}
