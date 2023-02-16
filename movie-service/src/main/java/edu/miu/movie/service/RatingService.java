package edu.miu.movie.service;

import edu.miu.movie.dto.RatingDTO;
import edu.miu.movie.entity.Rating;

public interface RatingService {

    Rating addRating(RatingDTO dto);
}
