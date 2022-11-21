package edu.miu.movie.dto;

import lombok.Data;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Data
public class CommentMovieDTO {

    private Long id;
    private String comment;
    private Long movieId;
    private Long userId;

    @Override
    public String toString() {
        return "CommentMovieDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", movieId=" + movieId +
                ", userId=" + userId +
                '}';
    }
}
