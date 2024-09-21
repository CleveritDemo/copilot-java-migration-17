package com.example.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.model.Movie;

@Stateless
public class MovieDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Movie getMovie(int id) {
        return entityManager.find(Movie.class, id);
    }

    public void addMovie(Movie movie) {
        entityManager.persist(movie);
    }

    public void updateMovie(Movie movie) {
        entityManager.merge(movie);
    }
}