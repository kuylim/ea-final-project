package edu.miu.movie.service.impl;

import edu.miu.movie.dto.RatingDTO;
import edu.miu.movie.entity.Movie;
import edu.miu.movie.entity.Rating;
import edu.miu.movie.repository.RatingRepository;
import edu.miu.movie.service.RatingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingServiceImpl  implements RatingService {

    private final RatingRepository repository;

    @Override
    public Rating addRating(RatingDTO dto) {
        Rating rating = new Rating();
        log.info("-===> dto: {}", dto);
        BeanUtils.copyProperties(dto, rating);
        rating = repository.save(rating);
        return rating;
    }
}
