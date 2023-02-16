package edu.miu.tvseries.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
public class TVSeriesDTO  {
    private Integer releaseYear;
    private Integer rating;
    private String genre;
    private String director;
    private String actor;
    private Double duration;
}
