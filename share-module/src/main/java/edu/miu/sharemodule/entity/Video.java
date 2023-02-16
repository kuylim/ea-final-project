package edu.miu.sharemodule.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Setter
@Getter
@MappedSuperclass
public class Video {

    private Integer releaseYear;
    private Integer rating =0;
    private String genre;
    private String director;
    private String actor;
    private Double duration;
}
