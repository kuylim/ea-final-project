package edu.miu.userservice.dto;

import edu.miu.sharemodule.enumerate.Role;
import lombok.Data;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@Data
public class UserDTO {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role;

}
