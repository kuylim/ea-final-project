package edu.miu.userservice.service;

import edu.miu.userservice.entity.MovieSnapshot;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@FeignClient(name = "MOVIE-SERVICE")
public interface MovieServiceClient {

    @GetMapping("/api/v1/movies/{id}")
    MovieSnapshot getByMovieById(@PathVariable Long id);
}
