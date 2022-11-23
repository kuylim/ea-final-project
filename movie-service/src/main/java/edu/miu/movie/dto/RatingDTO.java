package edu.miu.movie.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class RatingDTO {

   private Long id;
   private Double ratingNumber;
    private Long movieId;
    private Long userId;


}
