package edu.miu.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@Data
public class LoginDTO {

    private String username;
    private String password;
    @JsonIgnore
    private String clientId;
}
