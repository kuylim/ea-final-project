package edu.miu.movie.controller;


import edu.miu.movie.dto.MovieDTO;
import edu.miu.movie.dto.MovieFilter;
import edu.miu.movie.entity.Movie;
import edu.miu.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/filter")
    public List<Movie> getAllMovieByFilter( MovieFilter filter) {
        return movieService.getMovieByFilter(filter);
    }


    @PostMapping
    public Movie addMovie(@RequestBody MovieDTO movieDTO){
        return movieService.addMovie(movieDTO);
    }

    @GetMapping()
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getOneMovie(@PathVariable Long id){
        return movieService.getOneMovie(id);
    }

    @PutMapping("/{id}")

    public Movie editMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
        return movieService.editMovie(id,movieDTO);
    }
}
