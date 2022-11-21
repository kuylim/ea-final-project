package edu.miu.tvseries.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;
}
