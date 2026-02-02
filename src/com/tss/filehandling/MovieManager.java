package com.tss.filehandling;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class MovieManager {
    List<Movie>movies;
    public final int size = 5;
    static final String filePaht = "C:\\Users\\Darshit.Dhaduk\\Desktop\\FileHandling\\Movie\\Movies.txt";

    public MovieManager() throws IOException, ClassNotFoundException {
        movies = new ArrayList<>();
        loadMovies();
    }

    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }

    public List<Movie> getMovies()
    {
       return movies;
    }
    public int getSize()
    {
        return movies.size();
    }
//    public int getId(Movie movie)
//    {
//        return movie.getId();
//    }

    public void loadMovies() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filePaht);
        ObjectInputStream ois = new ObjectInputStream(fis);

        movies = Collections.singletonList((Movie) ois.readObject());

    }

    public void saveMovies() throws IOException {
        FileOutputStream fos = new FileOutputStream(filePaht,false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(Movie m : movies)
        {
            if(m == null)
                continue;
            else {
                oos.writeObject(m);
            }
        }
    }

    public void deleteAllMovies() throws IOException {
        FileOutputStream fos = new FileOutputStream(filePaht,false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        movies.clear();
    }
}
