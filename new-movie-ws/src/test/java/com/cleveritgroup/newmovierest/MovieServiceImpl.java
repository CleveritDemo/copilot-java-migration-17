package com.cleveritgroup.newmovierest;

import com.cleveritgroup.newmovierest.dao.MovieRepository;
import com.cleveritgroup.newmovierest.model.Movie;
import com.cleveritgroup.newmovierest.service.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMovieById_MovieExists() {
        Movie movie = new Movie();
        movie.setId(1);
        when(movieRepository.findById(1)).thenReturn(Optional.of(movie));

        Optional<Movie> result = movieService.getMovieById(1);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
    }

    @Test
    void testGetMovieById_MovieNotFound() {
        when(movieRepository.findById(1)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            movieService.getMovieById(1);
        });

        assertEquals("404 NOT_FOUND \"Movie not found\"", exception.getMessage());
    }

    @Test
    void testAddMovie_MovieAlreadyExists() {
        Movie movie = new Movie();
        movie.setName("Existing Movie");
        when(movieRepository.findAll()).thenReturn(List.of(movie));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            movieService.addMovie(movie);
        });

        assertEquals("409 CONFLICT \"Movie already exists\"", exception.getMessage());
    }

    @Test
    void testAddMovie_Success() {
        Movie movie = new Movie();
        movie.setName("New Movie");
        when(movieRepository.findAll()).thenReturn(List.of());
        when(movieRepository.save(movie)).thenReturn(movie);

        Movie result = movieService.addMovie(movie);

        assertNotNull(result);
        assertEquals("New Movie", result.getName());
    }

    @Test
    void testUpdateMovie_MovieNotFound() {
        Movie movie = new Movie();
        movie.setId(1);
        when(movieRepository.existsById(1)).thenReturn(false);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            movieService.updateMovie(movie);
        });

        assertEquals("404 NOT_FOUND \"Movie not found\"", exception.getMessage());
    }

    @Test
    void testUpdateMovie_Success() {
        Movie movie = new Movie();
        movie.setId(1);
        when(movieRepository.existsById(1)).thenReturn(true);
        when(movieRepository.save(movie)).thenReturn(movie);

        Movie result = movieService.updateMovie(movie);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    void testDeleteMovie_MovieNotFound() {
        when(movieRepository.existsById(1)).thenReturn(false);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            movieService.deleteMovie(1);
        });

        assertEquals("404 NOT_FOUND \"Movie not found\"", exception.getMessage());
    }

    @Test
    void testDeleteMovie_Success() {
        when(movieRepository.existsById(1)).thenReturn(true);
        doNothing().when(movieRepository).deleteById(1);

        assertDoesNotThrow(() -> {
            movieService.deleteMovie(1);
        });
    }
}