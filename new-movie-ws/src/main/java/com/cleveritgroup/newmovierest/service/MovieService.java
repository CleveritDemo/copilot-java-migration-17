package com.cleveritgroup.newmovierest.service;

import com.cleveritgroup.newmovierest.model.Movie;

import java.util.Optional;

public interface MovieService {
    Optional<Movie> getMovieById(int id);
    Movie addMovie(Movie movie);
    Movie updateMovie(Movie movie);
    void deleteMovie(int id);
}