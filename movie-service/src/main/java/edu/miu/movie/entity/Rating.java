package edu.miu.movie.entity;

import javax.persistence.*;

@Entity
public class Rating {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double ratingNumber;
    private Long movieId;
    private Long userId;


}
