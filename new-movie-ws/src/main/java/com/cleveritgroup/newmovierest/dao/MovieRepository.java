package com.cleveritgroup.newmovierest.dao;

import com.cleveritgroup.newmovierest.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
