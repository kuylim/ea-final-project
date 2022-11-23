package edu.miu.tvseries.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    private Long id;

    @Type(type = "text")
    private String comment;

    private Long movieOrTVSeriesId;

    private Long userId;
}
