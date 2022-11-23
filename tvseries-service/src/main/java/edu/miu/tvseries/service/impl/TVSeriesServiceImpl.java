package edu.miu.tvseries.service.impl;

import edu.miu.tvseries.controller.dto.MovieFilter;
import edu.miu.tvseries.controller.dto.TVSeriesDTO;
import edu.miu.tvseries.entity.TVSeries;
import edu.miu.tvseries.repository.TVSeriesRepository;
import edu.miu.tvseries.service.TVSeriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class TVSeriesServiceImpl implements TVSeriesService {

    private final TVSeriesRepository tvSeriesRepository;
    @Override
    public List<TVSeries> getTVSeriesByFilter(MovieFilter filter) {

        return tvSeriesRepository.findAllMovieByFilter(filter);
    }

    @Override
    public List<TVSeries> getAllTVSeries() {

        return tvSeriesRepository.findAll();
    }

    @Override
    public TVSeries getOneTVSeries(Long id) {

        TVSeries tvSeries=tvSeriesRepository.findById(id).get();
        log.info("-===> movie: {}", tvSeries);
        return tvSeries;
    }

    @Override
    public TVSeries addTVSeries(TVSeriesDTO tvSeriesDTO) {

        TVSeries tvSeries = new TVSeries();
        log.info("-===> dto: {}", tvSeriesDTO);
        BeanUtils.copyProperties(tvSeriesDTO, tvSeries, "id");
        tvSeries = tvSeriesRepository.save(tvSeries);
        return tvSeries;
    }

    @Override
    public void deletetTVSeries(Long id) {
        tvSeriesRepository.deleteById(id);
    }

    @Override
    public TVSeries editTVSeries(Long id, TVSeriesDTO tvSeriesDTO) {

        TVSeries tvSeries=tvSeriesRepository.findById(id).get();
        tvSeries.setActor(tvSeriesDTO.getActor());
        tvSeries.setGenre(tvSeriesDTO.getGenre());
        tvSeries.setDirector(tvSeriesDTO.getDirector());
        tvSeries.setDuration(tvSeriesDTO.getDuration());
        tvSeriesRepository.save(tvSeries);
        return tvSeries;
    }
}
