package edu.miu.userservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @PostMapping("/token")
    public Boolean login() {
        return false;
    }
}
