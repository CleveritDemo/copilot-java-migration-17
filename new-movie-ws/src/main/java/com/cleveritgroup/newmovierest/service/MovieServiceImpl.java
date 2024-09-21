package com.cleveritgroup.newmovierest.service;

import com.cleveritgroup.newmovierest.dao.MovieRepository;
import com.cleveritgroup.newmovierest.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Optional<Movie> getMovieById(int id) {
        return Optional.ofNullable(movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found")));
    }

    @Override
    public Movie addMovie(Movie movie) {
        boolean movieExists = movieRepository.findAll().stream()
                .anyMatch(existingMovie -> existingMovie.getName().equalsIgnoreCase(movie.getName()));
        if (movieExists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Movie already exists");
        }
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        if (!movieRepository.existsById(movie.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
        }
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(int id) {
        if (!movieRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
        }
        movieRepository.deleteById(id);
    }
}