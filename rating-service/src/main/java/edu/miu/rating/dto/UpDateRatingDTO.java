package edu.miu.rating.dto;

import edu.miu.sharemodule.enumerate.VideoType;
import lombok.Data;

@Data
public class UpDateRatingDTO {

    private Integer rating;
    //private Long movieOrTVSeriesId;
    private String videoType;
}
