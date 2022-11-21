package edu.miu.movie.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Entity
public class Comment {

    @Id
    private Long id;

    @Type(type = "text")
    private String comment;

    @ManyToOne
    private Movie movie;
}
