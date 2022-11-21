package edu.miu.tvseries.entity;

import edu.miu.sharemodule.entity.Video;
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
public class TVSeries extends Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "tvSeries")
    private List<Comment> comments;
}
