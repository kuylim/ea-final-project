package edu.miu.userservice.dto;

import edu.miu.sharemodule.enumerate.UserType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@Data
public class UserDTO {
    private String firstname;

    private String lastname;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
