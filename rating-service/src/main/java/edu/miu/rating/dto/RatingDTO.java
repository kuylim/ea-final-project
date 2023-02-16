package edu.miu.rating.dto;

import edu.miu.sharemodule.enumerate.VideoType;
import lombok.Data;

@Data
public class RatingDTO {

    private Long id;

    //@Type(type = "text")
    private Integer rating;

    private VideoType videoType;

    private Long movieOrTVSeriesId;

    private Long userId;
}
