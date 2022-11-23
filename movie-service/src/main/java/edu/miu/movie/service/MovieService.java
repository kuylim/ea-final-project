package edu.miu.movie.service;


import edu.miu.movie.dto.MovieDTO;
import edu.miu.movie.dto.MovieFilter;
import edu.miu.movie.entity.Movie;

import java.util.List;
import java.util.Optional;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
public interface MovieService {

    List<Movie> getMovieByFilter(MovieFilter filter);

    List<Movie> getAllMovies();

    Movie getOneMovie(Long id);

    Movie addMovie(MovieDTO movieDTO);

    void deleteMovie(Long id);

    Movie editMovie(Long id, MovieDTO movieDTO);

}
