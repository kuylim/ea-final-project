package edu.miu.rating.entity;

import edu.miu.sharemodule.enumerate.VideoType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Type(type = "text")
    private Integer rating;

    private String videoType;

    private Long movieOrTVSeriesId;

    private Long userId;
}
