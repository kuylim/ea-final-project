package edu.miu.tvseries.controller.dto;

import lombok.Data;

@Data
public class CommentTVSeriesDTO {

    private Long id;
    private String comment;
    private Long movieOrTVSeriesId;
    private Long userId;

    @Override
    public String toString() {
        return "CommentMovieDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", movieId=" + movieOrTVSeriesId +
                ", userId=" + userId +
                '}';
    }
}
