package edu.miu.userservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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


}
