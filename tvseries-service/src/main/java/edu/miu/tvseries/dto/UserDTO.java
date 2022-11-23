package edu.miu.tvseries.dto;

import edu.miu.sharemodule.enumerate.Role;
import lombok.Data;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@Data
public class UserDTO {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
