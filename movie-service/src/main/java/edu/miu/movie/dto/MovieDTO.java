package edu.miu.movie.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class MovieDTO {

    private Integer releaseYear;
    private Integer rating;
    private String genre;
    private String director;
    private String actor;
    private Double duration;
}
