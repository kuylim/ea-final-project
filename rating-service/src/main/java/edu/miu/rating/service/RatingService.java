package edu.miu.rating.service;

import edu.miu.rating.dto.RatingDTO;
import edu.miu.rating.dto.UpDateRatingDTO;
import edu.miu.rating.entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    public void createNewRating(Rating rating);

    public List<Rating> getListOfRatings();

    public UpDateRatingDTO upDateRating(Long id, UpDateRatingDTO rating);

    public void deleteRating(Long id);
}
