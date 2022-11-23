package edu.miu.userservice.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@Data
public class UserKeycloakDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String enabled;
    private List<Credential> credentials;
    private Map<String, List<String>> clientRoles;

    @Data
    public static class Credential {
        private String type;
        private String value;
        private Boolean temporary;
    }
}
