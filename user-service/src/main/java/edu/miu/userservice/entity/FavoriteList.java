package edu.miu.userservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@Setter
@Getter
@Entity
@Table(name = "tb_favorite_list")
public class FavoriteList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fav_seq")
    @SequenceGenerator(name = "fav_seq", allocationSize = 5)
    private Long id;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "favoriteList", cascade = CascadeType.ALL)
    List<MovieSnapshot> movieSnapshots;

    @JsonManagedReference
    @OneToMany(mappedBy = "favoriteList", cascade = CascadeType.ALL)
    List<TVSeriesSnapshot> tvSeriesSnapshots;

}
