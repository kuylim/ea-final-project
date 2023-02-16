package edu.miu.userservice.service;

import edu.miu.userservice.dto.FavoriteListDTO;
import edu.miu.userservice.dto.FavoriteMovieOrTvSeriesDTO;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
public interface FavoriteListService {

    FavoriteListDTO createFavoriteList(FavoriteListDTO dto);

    Boolean addMovieOrTVSeriesToFavoriteList(FavoriteMovieOrTvSeriesDTO dto);

    Boolean removeMovieOrTVSeriesFromFavoriteList(Long id);
}
