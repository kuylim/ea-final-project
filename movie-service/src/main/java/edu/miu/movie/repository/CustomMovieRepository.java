package edu.miu.movie.repository;

import edu.miu.movie.dto.MovieFilter;
import edu.miu.movie.entity.Movie;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
public interface CustomMovieRepository {

    List<Movie> findAllMovieByFilter(MovieFilter filter);
}
