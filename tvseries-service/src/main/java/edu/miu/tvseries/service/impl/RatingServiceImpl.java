package edu.miu.tvseries.service.impl;


import edu.miu.tvseries.controller.dto.RatingDTO;
import edu.miu.tvseries.entity.Rating;
import edu.miu.tvseries.repository.RatingRepository;
import edu.miu.tvseries.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

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
