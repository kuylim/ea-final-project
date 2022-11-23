package edu.miu.tvseries.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
