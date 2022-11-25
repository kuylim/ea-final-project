package edu.miu.tvseries.service.impl;


import edu.miu.tvseries.controller.dto.RatingDTO;
import edu.miu.tvseries.controller.dto.TVSeriesDTO;
import edu.miu.tvseries.entity.Rating;
import edu.miu.tvseries.repository.RatingRepository;
import edu.miu.tvseries.service.RatingService;
import edu.miu.tvseries.service.TVSeriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository repository;
    private final TVSeriesService tvSeriesService;

    @Override
    public Rating addRating(Rating dto) {
//        Rating rating = new Rating();
//        log.info("-===> dto: {}", dto);
//        BeanUtils.copyProperties(dto, rating);

        Rating r=repository.save(dto);
        List<Rating> allRating= (List<Rating>) repository.findAll();
        List<Rating> allRatingById =allRating.stream().
                filter(val-> val.getMovieOrTVSeriesId()==dto.getMovieOrTVSeriesId()).
                collect(Collectors.toList());
              final long num=1000;

      Integer ratingTotal=allRatingById.stream().map(val-> val.getRating()).
              reduce((init,total)-> init +total).get();

            Integer ratingValue= Math.toIntExact((ratingTotal / num )* 5);
             if(ratingValue< 6){
            TVSeriesDTO tvSeriesDTO=new TVSeriesDTO();

            tvSeriesDTO.setRating(ratingValue);
           log.info("-===> ratingtotal: {}", tvSeriesDTO);
           tvSeriesService.editTVSeries(dto.getMovieOrTVSeriesId(),tvSeriesDTO);
      }
       log.info("-===> allbyid: {}", allRatingById);
        log.info("-===> total: {}", ratingValue);
        log.info("-===> ratingtotal: {}", ratingTotal);
        return r;
    }

    @Override
    public List<Rating> getAllRatingById(Long id) {
        return (List<Rating>) repository.findAll();
    }
}
