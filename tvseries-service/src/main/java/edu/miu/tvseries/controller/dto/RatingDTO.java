package edu.miu.tvseries.controller.dto;

import edu.miu.sharemodule.enumerate.VideoType;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
public class RatingDTO {

    private Long id;

    //@Type(type = "text")
    private Integer rating;

    private VideoType videoType;

    private Long movieOrTVSeriesId;

    private Long userId;
}
