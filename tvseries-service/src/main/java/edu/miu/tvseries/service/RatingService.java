package edu.miu.tvseries.service;


import edu.miu.tvseries.controller.dto.RatingDTO;
import edu.miu.tvseries.entity.Rating;

public interface RatingService {

    Rating addRating(RatingDTO dto);
}
