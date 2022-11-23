package edu.miu.rating.dto;

import edu.miu.sharemodule.enumerate.VideoType;
import lombok.Data;

@Data
public class RatingDTO {

    private Integer rating;
    private Long movieOrTVSeriesId;
    private VideoType videoType;
    private Long userId;
}
