package edu.miu.userservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.sharemodule.entity.Video;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@Setter
@Getter
@Entity
public class MovieSnapshot extends Video {

    @Id
    private Long id;

    @ManyToOne
    @JsonBackReference
    private FavoriteList favoriteList;
}
