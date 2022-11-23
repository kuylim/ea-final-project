package edu.miu.rating.service.RatingServiceImpl;

import edu.miu.rating.dto.RatingDTO;
import edu.miu.rating.dto.UpDateRatingDTO;
import edu.miu.rating.entity.Rating;
import edu.miu.rating.repository.RatingRepository;
import edu.miu.rating.service.RatingService;
import edu.miu.sharemodule.enumerate.VideoType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final AmqpTemplate amqpTemplate;

    public RatingServiceImpl(RatingRepository repository,
                              @Qualifier("customRabbitTemplate") AmqpTemplate amqpTemplate) {
        this.ratingRepository = repository;
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void createNewRating(Rating rating) {
        ratingRepository.save(rating);
        /*log.info("-===> dto: {}", dto);
        BeanUtils.copyProperties(dto, rating, "id");
        rating = ratingRepository.save(rating);
        log.info("===> entity: {}", rating);*/
        if(VideoType.MOVIE.equals(rating.getVideoType())) {
            amqpTemplate.convertAndSend("rating-exchange", "rating-movie-queue", rating);
        }
        amqpTemplate.convertAndSend("rating-exchange", "rating-tvseries-queue", rating);
    }

    @Override
    public List<Rating> getListOfRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public UpDateRatingDTO upDateRating(Long id, UpDateRatingDTO rate) {
        Rating rating = ratingRepository.findById(id).orElse(null);
        if(rating != null) {
            rating.setRating(rate.getRating());
        }
        ratingRepository.save(rating);
        if(VideoType.MOVIE.equals(rating.getVideoType())) {
            amqpTemplate.convertAndSend("rating-exchange", "rating-movie-queue", rating);
        }
        amqpTemplate.convertAndSend("rating-exchange", "rating-tvseries-queue", rating);
        return rate;
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
