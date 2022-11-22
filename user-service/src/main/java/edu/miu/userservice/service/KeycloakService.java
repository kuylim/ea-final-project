package edu.miu.userservice.service;

import edu.miu.userservice.dto.LoginDTO;
import edu.miu.userservice.dto.UserDTO;

import java.util.Map;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
public interface KeycloakService {

    Map<String, Object> getAccessToken(LoginDTO dto);

    Map<String, Object> createUser(UserDTO dto);
}
