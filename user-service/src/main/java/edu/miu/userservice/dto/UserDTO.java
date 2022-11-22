package edu.miu.userservice.dto;

import edu.miu.sharemodule.enumerate.RoleType;
import edu.miu.sharemodule.enumerate.UserType;
import lombok.Data;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@Data
public class UserDTO {
    private String firstname;

    private String lastname;

    private String password;

    private RoleType roleType;

    private UserType userType;
}
