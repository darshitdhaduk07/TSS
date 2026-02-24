package com.tss.filehandling.movieapp.controller;

import com.tss.filehandling.movieapp.module.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManager implements Serializable {

    private List<Movie> movies;
    static final String filePath = "/Users/darshitdhaduk/Desktop/Movies/Movies";

    public MovieManager() {
        movies = new ArrayList<>();
        loadMovies();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public int getSize() {
        return movies.size();
    }

    public void loadMovies() {
        File file = new File(filePath);

        if (!file.exists() || file.length() == 0) return;

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            this.movies = (List<Movie>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveMovies() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(filePath))) {

            oos.writeObject(movies);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void clearMovies() {
        movies.clear();
    }
    public void deleteAllMovies() {
        movies.clear();
        saveMovies();
    }
}
