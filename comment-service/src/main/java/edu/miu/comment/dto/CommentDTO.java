package edu.miu.comment.dto;

import edu.miu.sharemodule.enumerate.VideoType;
import lombok.Data;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Data
public class CommentDTO {
    private String comment;
    private Long movieOrTVSeriesId;
    private VideoType videoType;
    private Long userId;
}
