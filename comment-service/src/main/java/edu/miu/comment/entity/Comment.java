package edu.miu.comment.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type = "text")
    private String comment;

    private Long movieId;

    private Long userId;
}
