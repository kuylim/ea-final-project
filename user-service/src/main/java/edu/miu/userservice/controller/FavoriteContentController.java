package edu.miu.userservice.controller;

import edu.miu.userservice.dto.FavoriteListDTO;
import edu.miu.userservice.dto.FavoriteMovieOrTvSeriesDTO;
import edu.miu.userservice.service.FavoriteListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@RestController
@RequestMapping("/api/v1/favorite")
@RequiredArgsConstructor
public class FavoriteContentController {

    private final FavoriteListService service;

    @PostMapping
    public FavoriteListDTO createFavoriteList(@RequestBody FavoriteListDTO dto) {
        return service.createFavoriteList(dto);
    }

    @PostMapping("/movie-tv-series")
    public Boolean addMovieOrTVSeriesToFavoriteList(@RequestBody FavoriteMovieOrTvSeriesDTO dto) {
        return service.addMovieOrTVSeriesToFavoriteList(dto);
    }

    @DeleteMapping("/movie-tv-series/{id}")
    public Boolean removeMovieOrTVSeriesFromFavoriteList(@PathVariable Long id) {
        return service.removeMovieOrTVSeriesFromFavoriteList(id);
    }
}
