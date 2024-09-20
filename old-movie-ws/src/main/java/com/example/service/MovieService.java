package com.example.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.dao.MovieDAO;
import com.example.model.Movie;

@Stateless
public class MovieService {

    @Inject
    private MovieDAO movieDAO;

    public Movie getMovieById(int id) {
        return movieDAO.getMovie(id);
    }

    public Movie addMovie(Movie movie) {
        movieDAO.addMovie(movie);
        return movie;
    }

    public Movie updateMovie(Movie movie) {
        movieDAO.updateMovie(movie);
        return movie;
    }
}