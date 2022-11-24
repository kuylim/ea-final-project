package edu.miu.userservice.controller;

import edu.miu.userservice.dto.LoginDTO;
import edu.miu.userservice.dto.UserDTO;
import edu.miu.userservice.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final KeycloakService keycloakService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginDTO dto) {
        return keycloakService.getAccessToken(dto);
    }

    @PostMapping("/register")
    public Boolean register(@RequestBody UserDTO dto) {
        return keycloakService.createUser(dto);
    }
}
