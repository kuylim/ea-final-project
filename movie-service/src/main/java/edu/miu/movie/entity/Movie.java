package edu.miu.movie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.sharemodule.entity.Video;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Setter
@Getter
@Entity
@Data
public class Movie extends Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movieOrTVSeriesId")
    private List<Comment> comments;
}
