package edu.miu.tvseries.service;

import edu.miu.tvseries.controller.dto.MovieFilter;
import edu.miu.tvseries.controller.dto.TVSeriesDTO;
import edu.miu.tvseries.entity.TVSeries;

import java.util.List;

public interface TVSeriesService {

    List<TVSeries> getTVSeriesByFilter(MovieFilter filter);

    List<TVSeries> getAllTVSeries();

    TVSeries getOneTVSeries(Long id);

    TVSeries addTVSeries(TVSeriesDTO tvSeriesDTO);

    void deletetTVSeries(Long id);

    TVSeries editTVSeries(Long id, TVSeriesDTO tvSeriesDTO);
}
