package edu.miu.rating.controller;

import edu.miu.rating.dto.RatingDTO;
import edu.miu.rating.dto.UpDateRatingDTO;
import edu.miu.rating.entity.Rating;
import edu.miu.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PostMapping
    public void createNewComment(@RequestBody RatingDTO rating) {


        ratingService.createNewRating(rating);
    }

    @GetMapping()
    public List<Rating> getListOfRatings(){
        return ratingService.getListOfRatings();
    }

    @GetMapping("/movies")
    public List<Rating> getListOfMovieRatings(){
        return ratingService.getListOfRatings().stream().filter(e -> e.getVideoType().equals("MOVIE")).collect(Collectors.toList());
    }

    @GetMapping("/tvseries")
    public List<Rating> getListOfTVSeriesRatings(){
        return ratingService.getListOfRatings().stream().filter(e -> e.getVideoType().equals("TVSERIES")).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id){
        ratingService.deleteRating(id);
    }

    @PutMapping("/{id}")
    public UpDateRatingDTO upDateRating(@PathVariable Long id, @RequestBody UpDateRatingDTO rating){
        return ratingService.upDateRating(id, rating);
    }
}
