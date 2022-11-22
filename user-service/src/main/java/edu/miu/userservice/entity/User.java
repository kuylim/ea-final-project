package edu.miu.userservice.entity;

import edu.miu.sharemodule.enumerate.RoleType;
import edu.miu.sharemodule.enumerate.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@Setter
@Getter
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;

    private String lastname;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
