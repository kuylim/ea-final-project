package edu.miu.tvseries.entity;

import edu.miu.sharemodule.enumerate.VideoType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rating {

    @Id
    private Long id;

    //@Type(type = "text")
    private Integer rating;

    private VideoType videoType;

    private Long movieOrTVSeriesId;

    private Long userId;


}
