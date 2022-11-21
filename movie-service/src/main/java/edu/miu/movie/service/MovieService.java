package edu.miu.movie.service;

import edu.miu.movie.dto.MovieFilter;
import edu.miu.movie.entity.Movie;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
public interface MovieService {

    List<Movie> getMovieByFilter(MovieFilter filter);
}
