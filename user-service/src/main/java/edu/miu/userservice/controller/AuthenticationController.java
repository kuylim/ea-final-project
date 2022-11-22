package edu.miu.userservice.controller;

import edu.miu.userservice.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final KeycloakService service;

    @PostMapping("/token")
    public Boolean login() {
        service.createUser(null);
        return false;
    }
}
