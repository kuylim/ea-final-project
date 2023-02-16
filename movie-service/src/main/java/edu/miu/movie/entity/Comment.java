package edu.miu.movie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
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
