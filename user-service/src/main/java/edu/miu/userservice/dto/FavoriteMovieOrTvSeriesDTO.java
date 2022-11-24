package edu.miu.userservice.dto;

import edu.miu.sharemodule.enumerate.VideoType;
import lombok.Data;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@Data
public class FavoriteMovieOrTvSeriesDTO {

    private Long favoriteListId;
    private Long movieOrTvSeriesId;
    private VideoType videoType;
}
