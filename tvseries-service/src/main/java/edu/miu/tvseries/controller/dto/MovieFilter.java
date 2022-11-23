package edu.miu.tvseries.controller.dto;

import lombok.Data;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Data
public class MovieFilter {

    private Integer releaseYear;
    private Integer rating;
    private String genre;
    private String director;
    private String actor;
    private Double duration;
}
