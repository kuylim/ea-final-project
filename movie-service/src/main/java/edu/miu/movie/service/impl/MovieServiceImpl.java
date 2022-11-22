package edu.miu.movie.service.impl;

import edu.miu.movie.dto.MovieFilter;
import edu.miu.movie.entity.Movie;
import edu.miu.movie.repository.MovieRepository;
import edu.miu.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

    @Override
    public List<Movie> getMovieByFilter(MovieFilter filter) {
       return repository.findAllMovieByFilter(filter);
    }
}
