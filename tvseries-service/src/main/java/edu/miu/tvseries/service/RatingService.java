package edu.miu.tvseries.service;


import edu.miu.tvseries.controller.dto.RatingDTO;
import edu.miu.tvseries.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating addRating(Rating dto);

    List<Rating> getAllRatingById(Long id);
}
