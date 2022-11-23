package edu.miu.tvseries.repository;


import edu.miu.tvseries.controller.dto.MovieFilter;
import edu.miu.tvseries.entity.TVSeries;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
public interface CustomTVSeriesRepository {

    List<TVSeries> findAllMovieByFilter(MovieFilter filter);
}
